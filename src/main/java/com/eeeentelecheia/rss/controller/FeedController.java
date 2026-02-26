package com.eeeentelecheia.rss.controller;

import com.eeeentelecheia.rss.pojo.Feed;
import com.eeeentelecheia.rss.service.FeedService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping
    public List<Feed> list() {
        return feedService.findAll();
    }

    @GetMapping("/{id}")
    public Feed get(@PathVariable Integer id) {
        return feedService.findById(id);
    }

    @PostMapping
    public String add(@RequestBody Feed feed) {
        try {
            feedService.add(feed);
            return "添加成功";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody Feed feed) {
        feed.setId(id);
        try {
            feedService.update(feed);
            return "更新成功";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        feedService.deleteById(id);
        return "删除成功";
    }
}
