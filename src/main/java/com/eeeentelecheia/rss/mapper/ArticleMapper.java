package com.eeeentelecheia.rss.mapper;

import com.eeeentelecheia.rss.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
//    List<Article> findAll();
    void createArticlesTable();
    // 插入
    void insert(Article article);

    // 批量插入（抓取时使用）
    void batchInsert(@Param("list") List<Article> articles);

    // 根据订阅源查询文章
    List<Article> findByFeedId(@Param("feedId") Integer feedId,
                               @Param("offset") int offset,
                               @Param("limit") int limit);

    // 查询所有文章（分页），并关联订阅源信息
    List<Article> findAllWithFeed(@Param("offset") int offset,
                                  @Param("limit") int limit);

    // 获取总记录数
    long countAll();

    // 根据订阅源统计文章数
    long countByFeedId(@Param("feedId") Integer feedId);

    // 标记为已读
    void markAsRead(@Param("id") Integer id);
}
