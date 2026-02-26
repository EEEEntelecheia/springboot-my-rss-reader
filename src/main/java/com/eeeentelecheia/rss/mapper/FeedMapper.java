package com.eeeentelecheia.rss.mapper;

import com.eeeentelecheia.rss.pojo.Feed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface FeedMapper {
//    List<Feed> findAll();
    void createFeedsTable();

    void insert(Feed feed);

    // 根据 id 查询
    Feed findById(@Param("id") Integer id);

    // 根据 url 查询
    Feed findByUrl(@Param("url") String url);

    // 查询所有
    List<Feed> findAll();

    // 更新
    void update(Feed feed);

    // 删除
    void deleteById(@Param("id") Integer id);

    // 统计数量（用于判断是否需要插入默认数据）
    int count();

    // 查询url是否存在（用于避免重复插入数据）
    int countByUrl(@Param("url") String url);
}
