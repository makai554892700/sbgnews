package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.VideoBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("videoBSBDJMapper")
public interface VideoBSBDJMapper extends JpaRepository<VideoBSBDJ, Integer> {

    public VideoBSBDJ getVideoBSBDJByMark(String mark);

}
