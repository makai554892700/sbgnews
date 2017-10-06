package com.mayousheng.www.sbgnews.vo.response.base;

public class BaseNewsResponse {

    private Integer mark;        //唯一标记
    private NewsDesc newsDesc;  //新闻描述
    private UserDesc userDesc;  //用户描述
    private String text;        //基本内容

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
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

    @Override
    public String toString() {
        return "BaseNewsResponse{" +
                "mark='" + mark + '\'' +
                ", newsDesc=" + newsDesc +
                ", userDesc=" + userDesc +
                ", text='" + text + '\'' +
                '}';
    }
}