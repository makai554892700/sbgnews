package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.mapper.CommentMapper;
import com.mayousheng.www.sbgnews.mapper.NewsOperateMapper;
import com.mayousheng.www.sbgnews.pojo.SessionUser;
import com.mayousheng.www.sbgnews.pojo.operate.Comment;
import com.mayousheng.www.sbgnews.service.OperateService;
import com.mayousheng.www.sbgnews.vo.request.NewsCommentRequest;
import com.mayousheng.www.sbgnews.vo.request.NewsOperateRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
    public String love(NewsOperateRequest newsMark) {
        newsOperateMapper.love(newsMark.getNewsMark(), newsMark.getNewsType());
        return StaticParam.OK;
    }

    @Override
    public String hate(NewsOperateRequest newsMark) {
        newsOperateMapper.hate(newsMark.getNewsMark(), newsMark.getNewsType());
        return StaticParam.OK;
    }

    @Override
    public String share(NewsOperateRequest newsMark) {
        newsOperateMapper.share(newsMark.getNewsMark(), newsMark.getNewsType());
        return StaticParam.OK;
    }

    @Override
    public String comment(NewsCommentRequest newsComment) {
        NewsOperateRequest newsMark = newsComment.getNewsMark();
        newsOperateMapper.comment(newsMark.getNewsMark()
                , newsMark.getNewsType());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        SessionUser sessionUser = (SessionUser) session.getAttribute(StaticParam.SHIRO_USER);
        commentMapper.save(new Comment(sessionUser.getId(), newsMark.getNewsMark()
                , newsMark.getNewsType(), newsComment.getCommentInfo()));
        return StaticParam.OK;
    }
}
