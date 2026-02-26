package com.eeeentelecheia.rss.service;

import com.eeeentelecheia.rss.mapper.ArticleMapper;
import com.eeeentelecheia.rss.mapper.FeedMapper;
import com.eeeentelecheia.rss.pojo.Article;
import com.eeeentelecheia.rss.pojo.Feed;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FetchServiceImpl implements FetchService {

    @Autowired
    private FeedMapper feedMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void fetchFeed(String feedUrl) {
        try {
            // 1. 通过 Rome 解析 RSS
            URL url = new URL(feedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input.build(new XmlReader(url));

            // 2. 获取 Feed 对应的数据库记录（用于 feedId）
            Feed feed = feedMapper.findByUrl(feedUrl);
            if (feed == null) {
                // 如果订阅源不存在，则忽略（或者可以抛异常）
                return;
            }

            // 3. 遍历文章，去重后插入
            List<Article> newArticles = new ArrayList<>();
            for (SyndEntry entry : syndFeed.getEntries()) {
                String link = entry.getLink();
                // 检查是否已存在
                if (articleMapper.existsByLink(link)) {
                    continue;
                }

                Article article = new Article();
                article.setTitle(entry.getTitle());
                article.setLink(link);
                article.setPublished((Data) (entry.getPublishedDate() != null ? entry.getPublishedDate() : new Date()));
                article.setSummary(entry.getDescription() != null ? entry.getDescription().getValue() : "");
                article.setIsRead(false);
                article.setFeedId(feed.getId());

                newArticles.add(article);
            }

            // 批量插入（如果列表不为空）
            if (!newArticles.isEmpty()) {
                articleMapper.batchInsert(newArticles);
            }
        } catch (Exception e) {
            // 记录日志（可以使用 log.error）
            System.err.println("抓取失败: " + feedUrl + " - " + e.getMessage());
            // 可根据需要抛出运行时异常，触发事务回滚
            // throw new RuntimeException("抓取失败", e);
        }
    }

    @Override
    @Scheduled(fixedDelay = 3600000) // 每小时执行一次，单位毫秒
    public void fetchAllFeeds() {
        List<Feed> feeds = feedMapper.findAll();
        for (Feed feed : feeds) {
            fetchFeed(feed.getUrl());
        }
    }
}
