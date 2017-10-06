package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.PunsterBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("punsterBSBDJMapper")
public interface PunsterBSBDJMapper extends JpaRepository<PunsterBSBDJ, Integer> {

    public PunsterBSBDJ getPunsterBSBDJByMark(Integer mark);

    @Query(nativeQuery = true, value = "select * from punsterbsbdj order by id desc limit :offset,:count")
    public List<PunsterBSBDJ> getPunsterBySearch(@Param("count") Integer count, @Param("offset") Integer offset);

}
