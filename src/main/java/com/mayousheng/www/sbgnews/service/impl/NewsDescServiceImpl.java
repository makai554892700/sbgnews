package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.CommentMapper;
import com.mayousheng.www.sbgnews.pojo.operate.Comment;
import com.mayousheng.www.sbgnews.service.NewsDescService;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("newsDescServiceImpl")
public class NewsDescServiceImpl implements NewsDescService {
    @Resource(name = "commentMapper")
    private CommentMapper commentMapper;

    @Override
    public NewsDesc getNewsDesc(String createTime, Integer descId, String tableName) {
        List<Comment> commentList = commentMapper.getCommentsByDescIdAndTableName(descId, tableName);
        return new NewsDesc(0, 0, 0, commentList.size(), createTime);
    }
}
