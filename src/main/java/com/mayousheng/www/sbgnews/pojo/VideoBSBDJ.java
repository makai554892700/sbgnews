package com.mayousheng.www.sbgnews.pojo;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//百思不得姐-视频
@Entity
public class VideoBSBDJ {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer mark;           //标记(id)
    private Integer userId;         //用户id(对应用户信息)
    private String weixinUrl;       //微信(原文)路径
    @Type(type = "text")
    private String text;            //视频标题
    private String videoUri;        //视频url
    private String createTime;      //创建时间

    public VideoBSBDJ() {
    }

    public VideoBSBDJ(Integer mark, Integer userId, String weixinUrl, String text
            , String videoUri, String createTime) {
        this.mark = mark;
        this.userId = userId;
        this.weixinUrl = weixinUrl;
        this.text = text;
        this.videoUri = videoUri;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWeixinUrl() {
        return weixinUrl;
    }

    public void setWeixinUrl(String weixinUrl) {
        this.weixinUrl = weixinUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VideoBSBDJ{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", userId=" + userId +
                ", weixinUrl='" + weixinUrl + '\'' +
                ", text='" + text + '\'' +
                ", videoUri='" + videoUri + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
