package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.bsbdj.VideoBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("videoBSBDJMapper")
public interface VideoBSBDJMapper extends JpaRepository<VideoBSBDJ, Integer> {

    public VideoBSBDJ getVideoBSBDJByMark(String mark);

    @Query(nativeQuery = true, value = "select * from videobsbdj order by id desc limit :offset,:count")
    public List<VideoBSBDJ> getVideoBySearch(@Param("count") Integer count, @Param("offset") Integer offset);

}
