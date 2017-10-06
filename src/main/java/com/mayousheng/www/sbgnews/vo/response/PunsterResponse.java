package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class PunsterResponse extends BaseNewsResponse {

    public PunsterResponse() {
    }

    public PunsterResponse(Integer mark, NewsDesc newsDesc, UserDesc userDesc, String text) {
        setMark(mark);
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
    }

}
