package com.mayousheng.www.sbgnews.vo.response.base;

public class NewsDesc {

    private Integer love;         //点赞的数量
    private Integer hate;         //点踩的数量
    private Integer share;        //分享的数量
    private Integer comment;      //评论的数量
    private Integer newsMark;      //新闻标记(id)
    private String newsType;      //新闻类型
    private String createTime;    //创建时间

    public NewsDesc() {
    }

    public NewsDesc(Integer love, Integer hate, Integer share
            , Integer comment, Integer newsMark, String newsType
            , String createTime) {
        this.love = love;
        this.hate = hate;
        this.share = share;
        this.comment = comment;
        this.newsMark = newsMark;
        this.newsType = newsType;
        this.createTime = createTime;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Integer getHate() {
        return hate;
    }

    public void setHate(Integer hate) {
        this.hate = hate;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "NewsDesc{" +
                "love=" + love +
                ", hate=" + hate +
                ", share=" + share +
                ", comment=" + comment +
                ", newsMark=" + newsMark +
                ", newsType='" + newsType + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
