package com.eeeentelecheia.rss.config;

import com.eeeentelecheia.rss.mapper.ArticleMapper;
import com.eeeentelecheia.rss.mapper.FeedMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    @Autowired
    private FeedMapper feedMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @PostConstruct
    public void init() {
        System.out.println("DatabaseInitializer.init");
        feedMapper.createFeedsTable();   // 执行一次建表
        articleMapper.createArticlesTable(); //在这里分别创建 feeds、article 表

    }
}
