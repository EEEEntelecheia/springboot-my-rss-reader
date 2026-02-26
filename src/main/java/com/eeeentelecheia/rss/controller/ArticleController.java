package com.eeeentelecheia.rss.controller;

import com.eeeentelecheia.rss.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    public Map<String, Object> listAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return articleService.listAll(page, pageSize);
    }

    @GetMapping("/feed/{feedId}")
    public Map<String, Object> listByFeed(
            @PathVariable Integer feedId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return articleService.listByFeedId(feedId, page, pageSize);
    }

    @PutMapping("/{id}/read")
    public String markAsRead(@PathVariable Integer id) {
        articleService.markAsRead(id);
        return "标记已读成功";
    }
}
