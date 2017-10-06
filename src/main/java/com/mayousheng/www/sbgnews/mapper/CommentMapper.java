package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentMapper")
public interface CommentMapper extends JpaRepository<Comment, Integer> {

    public List<Comment> getCommentsByUserIdAndDescIdAndTableName(Integer userId, Integer descId, String tableName);

    public List<Comment> getCommentsByDescIdAndTableName(Integer descId, String tableName);

}
