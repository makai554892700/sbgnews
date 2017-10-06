package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("shareMapper")
public interface ShareMapper extends JpaRepository<Share, Integer> {

    public List<Share> getSharesByUserIdAndDescIdAndTableName(Integer userId, Integer descId, String tableName);

    public List<Share> getSharesByDescIdAndTableName(Integer descId, String tableName);

}
