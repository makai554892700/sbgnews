package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.operate.NewsOperate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("newsOperateMapper")
public interface NewsOperateMapper extends JpaRepository<NewsOperate, Integer> {

    public NewsOperate getNewsOperateByTableNameAndNewsId(String tableName, Integer newsId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE NewsOperate SET love = love + 1 WHERE news_id = ?1 and table_name = ?2")
    public void love(Integer newsMark, String newsType);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE NewsOperate SET hate = hate + 1 WHERE news_id = ?1 and table_name = ?2")
    public void hate(Integer newsMark, String newsType);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE NewsOperate SET share = share + 1 WHERE news_id = ?1 and table_name = ?2")
    public void share(Integer newsMark, String newsType);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE NewsOperate SET comment = comment + 1 WHERE news_id = ?1 and table_name = ?2")
    public void comment(Integer newsMark, String newsType);

}
