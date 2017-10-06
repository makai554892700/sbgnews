package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.Hate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hateMapper")
public interface HateMapper extends JpaRepository<Hate, Integer> {

    public List<Hate> getHatesByUserIdAndDescIdAndTableName(Integer userId, Integer descId, String tableName);

    public List<Hate> getHatesByDescIdAndTableName(Integer descId, String tableName);

}
