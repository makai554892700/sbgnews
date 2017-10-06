package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.CommentMapper;
import com.mayousheng.www.sbgnews.mapper.HateMapper;
import com.mayousheng.www.sbgnews.mapper.LoveMapper;
import com.mayousheng.www.sbgnews.mapper.ShareMapper;
import com.mayousheng.www.sbgnews.pojo.Comment;
import com.mayousheng.www.sbgnews.pojo.Hate;
import com.mayousheng.www.sbgnews.pojo.Love;
import com.mayousheng.www.sbgnews.pojo.Share;
import com.mayousheng.www.sbgnews.service.NewsDescService;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("newsDescServiceImpl")
public class NewsDescServiceImpl implements NewsDescService {

    @Resource(name = "loveMapper")
    private LoveMapper loveMapper;
    @Resource(name = "hateMapper")
    private HateMapper hateMapper;
    @Resource(name = "shareMapper")
    private ShareMapper shareMapper;
    @Resource(name = "commentMapper")
    private CommentMapper commentMapper;

    @Override
    public NewsDesc getNewsDesc(String createTime, Integer descId, String tableName) {
        List<Love> loveList = loveMapper.getLovesByDescIdAndTableName(descId, tableName);
        List<Hate> hateList = hateMapper.getHatesByDescIdAndTableName(descId, tableName);
        List<Share> shareList = shareMapper.getSharesByDescIdAndTableName(descId, tableName);
        List<Comment> commentList = commentMapper.getCommentsByDescIdAndTableName(descId, tableName);
        return new NewsDesc(loveList.size(), hateList.size(), shareList.size(), commentList.size(), createTime);
    }
}
