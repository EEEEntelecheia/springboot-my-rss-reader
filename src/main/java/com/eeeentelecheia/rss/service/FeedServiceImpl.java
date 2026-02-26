package com.eeeentelecheia.rss.service;

import com.eeeentelecheia.rss.mapper.FeedMapper;
import com.eeeentelecheia.rss.pojo.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private FeedMapper feedMapper;

    @Override
    public List<Feed> findAll() {
        return feedMapper.findAll();
    }

    @Override
    public Feed findById(Integer id) {
        return feedMapper.findById(id);
    }

    @Override
    @Transactional
    public void add(Feed feed) {
        // 业务校验：URL不能重复
        if (feedMapper.countByUrl(feed.getUrl()) > 0) {
            throw new RuntimeException("该订阅源URL已存在");
        }
        feedMapper.insert(feed);
        // 添加后立即抓取一次（可选，调用抓取服务）
        // feedFetchService.fetch(feed.getUrl());
    }

    @Override
    public void update(Feed feed) {
        // 更新时URL可能未变，需要排除自身
        Feed existing = feedMapper.findByUrl(feed.getUrl());
        if (existing != null && !existing.getId().equals(feed.getId())) {
            throw new RuntimeException("该订阅源URL已被其他订阅源使用");
        }
        feedMapper.update(feed);
    }

    @Override
    public void deleteById(Integer id) {
        feedMapper.deleteById(id);
    }

    @Override
    public boolean existsByUrl(String url) {
        if (feedMapper.countByUrl(url) > 0) {
            return true;
        }
        return false;
    }
}
