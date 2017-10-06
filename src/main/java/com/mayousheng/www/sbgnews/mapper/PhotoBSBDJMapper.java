package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.PhotoBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("photoBSBDJMapper")
public interface PhotoBSBDJMapper extends JpaRepository<PhotoBSBDJ, Integer> {

    public PhotoBSBDJ getPhotoBSBDJByMark(String mark);

}
