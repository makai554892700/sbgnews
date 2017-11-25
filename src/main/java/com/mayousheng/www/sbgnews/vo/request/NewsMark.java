package com.mayousheng.www.sbgnews.vo.request;

import org.hibernate.validator.constraints.NotEmpty;

public class NewsMark {

    @NotEmpty(message = "新闻标记不能为空")
    private Integer newsMark;
    @NotEmpty(message = "新闻类型不能为空")
    private String newsType;

    public Integer getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(Integer newsMark) {
        this.newsMark = newsMark;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString() {
        return "NewsMark{" +
                "newsMark='" + newsMark + '\'' +
                ", newsType='" + newsType + '\'' +
                '}';
    }
}
