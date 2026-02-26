package com.eeeentelecheia.rss.service;

import java.util.Map;

public interface ArticleService {
    Map<String, Object> listAll(int page, int pageSize);
    Map<String, Object> listByFeedId(Integer feedId, int page, int pageSize);
    void markAsRead(Integer id);
    // 抓取相关方法可单独抽出一个FeedFetchService
}
