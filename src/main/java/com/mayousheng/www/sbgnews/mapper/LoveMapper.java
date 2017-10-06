package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.Love;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loveMapper")
public interface LoveMapper extends JpaRepository<Love, Integer> {

    public List<Love> getLovesByUserIdAndDescIdAndTableName(Integer userId, Integer descId, String tableName);

    public List<Love> getLovesByDescIdAndTableName(Integer descId, String tableName);

}
