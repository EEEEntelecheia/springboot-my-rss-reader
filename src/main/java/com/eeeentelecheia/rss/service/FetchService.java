package com.eeeentelecheia.rss.service;

public interface FetchService {
    /**
     *抓取单个 RSS 源，返回新文章列表
     */
    void fetchFeed(String url);

    /**
     *抓取所有 RSS 源，返回新文章列表
     */
    void fetchAllFeeds();
}
