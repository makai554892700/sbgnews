package com.mayousheng.www.sbgnews.vo.response.base;

public class BaseNewsResponse {

    private String mark;        //唯一标记
    private NewsDesc newsDesc;  //新闻描述
    private UserDesc userDesc;  //用户描述
    private String text;        //基本内容
    private String url;   //详情跳转url

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public NewsDesc getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(NewsDesc newsDesc) {
        this.newsDesc = newsDesc;
    }

    public UserDesc getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(UserDesc userDesc) {
        this.userDesc = userDesc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
