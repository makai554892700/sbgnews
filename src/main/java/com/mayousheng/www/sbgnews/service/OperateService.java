package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.vo.request.NewsCommentRequest;
import com.mayousheng.www.sbgnews.vo.request.NewsOperateRequest;

public interface OperateService {

    public String love(NewsOperateRequest newsMark);

    public String hate(NewsOperateRequest newsMark);

    public String share(NewsOperateRequest newsMark);

    public String comment(NewsCommentRequest newsComment);

}
