package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.VoiceBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("voiceBSBDJMapper")
public interface VoiceBSBDJMapper extends JpaRepository<VoiceBSBDJ, Integer> {

    public VoiceBSBDJ getVoiceBSBDJByMark(String mark);

}
