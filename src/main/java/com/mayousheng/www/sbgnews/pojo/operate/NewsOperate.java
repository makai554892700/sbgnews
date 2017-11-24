package com.mayousheng.www.sbgnews.pojo.operate;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "newsId,tableName")})
public class NewsOperate {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Integer newsId;        //新闻id   int(unique)
    @Column(nullable = false)
    private String tableName;     //新闻表名  String(unique)
    private Integer love;           //点赞次数  int
    private Integer hate;           //点踩次数  int
    private Integer share;          //分享次数  int
    private Integer comment;          //评论次数  int

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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

    @Override
    public String toString() {
        return "NewsOperate{" +
                "id=" + id +
                ", newsId=" + newsId +
                ", tableName='" + tableName + '\'' +
                ", love=" + love +
                ", hate=" + hate +
                ", share=" + share +
                ", comment=" + comment +
                '}';
    }
}
