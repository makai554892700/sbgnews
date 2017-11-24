package com.mayousheng.www.sbgnews.pojo.bsbdj;

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
    private String mark;           //标记(id)
    private Integer userId;         //用户id(对应用户信息)
    private String weixinUrl;       //微信(原文)路径
    @Type(type = "text")
    private String text;            //视频标题
    private String videoUri;        //视频url
    private String scImg;        //视频缩略图url
    private Integer width;         //宽
    private Integer height;         //高
    private Integer playTime;         //播放时长
    private String createTime;      //创建时间

    public VideoBSBDJ() {
    }

    public VideoBSBDJ(String mark, Integer userId, String weixinUrl, String text, String videoUri, String scImg
            , Integer width, Integer height, Integer playTime, String createTime) {
        this.mark = mark;
        this.userId = userId;
        this.weixinUrl = weixinUrl;
        this.text = text;
        this.videoUri = videoUri;
        this.scImg = scImg;
        this.width = width;
        this.height = height;
        this.playTime = playTime;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
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

    public String getScImg() {
        return scImg;
    }

    public void setScImg(String scImg) {
        this.scImg = scImg;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
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
                ", scImg='" + scImg + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", playTime=" + playTime +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
