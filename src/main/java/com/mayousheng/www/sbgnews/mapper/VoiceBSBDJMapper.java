package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.VoiceBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("voiceBSBDJMapper")
public interface VoiceBSBDJMapper extends JpaRepository<VoiceBSBDJ, Integer> {

    public VoiceBSBDJ getVoiceBSBDJByMark(Integer mark);

    @Query(nativeQuery = true, value = "select * from voicebsbdj order by id desc limit :offset,:count")
    public List<VoiceBSBDJ> getVoiceBySearch(@Param("count") Integer count, @Param("offset") Integer offset);

}
