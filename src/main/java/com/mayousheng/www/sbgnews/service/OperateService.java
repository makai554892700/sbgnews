package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.vo.request.NewsComment;
import com.mayousheng.www.sbgnews.vo.request.NewsMark;

public interface OperateService {

    public String love(NewsMark newsMark);

    public String hate(NewsMark newsMark);

    public String share(NewsMark newsMark);

    public String comment(User user, NewsComment newsComment);

}
