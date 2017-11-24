package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.bsbdj.PhotoBSBDJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("photoBSBDJMapper")
public interface PhotoBSBDJMapper extends JpaRepository<PhotoBSBDJ, Integer> {

    public PhotoBSBDJ getPhotoBSBDJByMark(String mark);

    @Query(nativeQuery = true, value = "select * from photobsbdj order by id desc limit :offset,:count")
    public List<PhotoBSBDJ> getPhotoBySearch(@Param("count") Integer count, @Param("offset") Integer offset);

}
