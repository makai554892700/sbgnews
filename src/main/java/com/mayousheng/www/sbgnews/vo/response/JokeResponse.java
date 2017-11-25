package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class JokeResponse extends BaseNewsResponse {

    private String title;//标题

    public JokeResponse() {
    }

    public JokeResponse(NewsDesc newsDesc, UserDesc userDesc, String text, String title) {
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
