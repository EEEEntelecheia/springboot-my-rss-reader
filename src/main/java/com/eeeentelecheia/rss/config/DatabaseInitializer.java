package com.eeeentelecheia.rss.config;

import com.eeeentelecheia.rss.mapper.ArticleMapper;
import com.eeeentelecheia.rss.mapper.FeedMapper;
import jakarta.annotation.PostConstruct;
import org.apache.ibatis.logging.stdout.StdOutImpl;
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
        articleMapper.createArticlesTable(); // 也可以在这里创建 article 表

    }
}
