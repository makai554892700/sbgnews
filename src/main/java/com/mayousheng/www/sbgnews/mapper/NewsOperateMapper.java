package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.operate.NewsOperate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("newsOperateMapper")
public interface NewsOperateMapper extends JpaRepository<NewsOperate, Integer> {

    public NewsOperate getNewsOperateByTableNameAndNewsId(String tableName, Integer newsId);


    @Query(nativeQuery = true, value =
            "UPDATE news_operate SET 'love' = 'love' + 1 WHEN news_id = :newsMark and table_name = :newsType")
    public void love(@Param("newsMark") Integer newsMark, @Param("newsType") String newsType);

    @Query(nativeQuery = true, value =
            "UPDATE news_operate SET 'hate' = 'hate' + 1 WHEN news_id = :newsMark and table_name = :newsType")
    public void hate(@Param("newsMark") Integer newsMark, @Param("newsType") String newsType);

    @Query(nativeQuery = true, value =
            "UPDATE news_operate SET 'share' = 'share' + 1 WHEN news_id = :newsMark and table_name = :newsType")
    public void share(@Param("newsMark") Integer newsMark, @Param("newsType") String newsType);

    @Query(nativeQuery = true, value =
            "UPDATE news_operate SET 'comment' = 'comment' + 1 WHEN news_id = :newsMark and table_name = :newsType")
    public void comment(@Param("newsMark") Integer newsMark, @Param("newsType") String newsType);

}
