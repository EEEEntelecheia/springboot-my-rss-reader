package com.eeeentelecheia.rss.service;

import com.eeeentelecheia.rss.pojo.Feed;

import java.util.List;

public interface FeedService {
    List<Feed> findAll();
    Feed findById(Integer id);
    void add(Feed feed);
    void update(Feed feed);
    void deleteById(Integer id);
    boolean existsByUrl(String url);
}
