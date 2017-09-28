package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.TopNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("topNewsMapper")
public interface TopNewsMapper extends JpaRepository<TopNews, String> {

    public TopNews getTopNewsByUniquekey(String uniquekey);

    @Query(nativeQuery = true, value = "select * from top_news where type = :type order by id desc limit :offset  ,:count")
    public List<TopNews> getNewsBySearch(@Param("type") String type, @Param("offset") Integer offset, @Param("count") Integer count);

}
