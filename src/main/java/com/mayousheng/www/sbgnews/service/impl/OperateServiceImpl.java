package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.mapper.CommentMapper;
import com.mayousheng.www.sbgnews.mapper.NewsOperateMapper;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.pojo.operate.Comment;
import com.mayousheng.www.sbgnews.service.OperateService;
import com.mayousheng.www.sbgnews.vo.request.NewsComment;
import com.mayousheng.www.sbgnews.vo.request.NewsMark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("operateServiceImpl")
public class OperateServiceImpl implements OperateService {

    private Logger log = LoggerFactory.getLogger(OperateServiceImpl.class);

    @Resource(name = "newsOperateMapper")
    private NewsOperateMapper newsOperateMapper;
    @Resource(name = "commentMapper")
    private CommentMapper commentMapper;

    @Override
    public String love(NewsMark newsMark) {
        newsOperateMapper.love(newsMark.getNewsMark(), newsMark.getNewsType());
        return StaticParam.OK;
    }

    @Override
    public String hate(NewsMark newsMark) {
        newsOperateMapper.hate(newsMark.getNewsMark(), newsMark.getNewsType());
        return StaticParam.OK;
    }

    @Override
    public String share(NewsMark newsMark) {
        newsOperateMapper.share(newsMark.getNewsMark(), newsMark.getNewsType());
        return StaticParam.OK;
    }

    @Override
    public String comment(User user, NewsComment newsComment) {
        NewsMark newsMark = newsComment.getNewsMark();
        newsOperateMapper.comment(newsMark.getNewsMark()
                , newsMark.getNewsType());
        commentMapper.save(new Comment(user.getId(), newsMark.getNewsMark()
                , newsMark.getNewsType(), newsComment.getCommentInfo()));
        return StaticParam.OK;
    }
}
