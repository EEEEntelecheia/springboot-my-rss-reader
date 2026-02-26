package com.eeeentelecheia.rss.service;

import com.eeeentelecheia.rss.mapper.ArticleMapper;
import com.eeeentelecheia.rss.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Map<String, Object> listAll(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Article> list = articleMapper.findAllWithFeed(offset, pageSize);
        long total = articleMapper.countAll();
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("total", total);
        result.put("page", page);
        result.put("pageSize", pageSize);
        return result;
    }

    @Override
    public Map<String, Object> listByFeedId(Integer feedId, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Article> list = articleMapper.findByFeedId(feedId, offset, pageSize);
        long total = articleMapper.countByFeedId(feedId);
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("total", total);
        result.put("page", page);
        result.put("pageSize", pageSize);
        return result;
    }

    @Override
    public void markAsRead(Integer id) {
        articleMapper.markAsRead(id);
    }
}
