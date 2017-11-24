package com.mayousheng.www.sbgnews.pojo.bsbdj;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//百思不得姐-声音
@Entity
public class VoiceBSBDJ {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private String mark;           //标记(id)
    private Integer userId;         //用户id(对应用户信息)
    private String weixinUrl;       //微信(原文)路径
    @Type(type = "text")
    private String text;            //声音标题
    private String voiceuri;        //声音url
    private String cdnImg;            //cdn图片
    private Integer voiceTime;           //播放时长
    private String createTime;      //创建时间

    public VoiceBSBDJ() {
    }

    public VoiceBSBDJ(String mark, Integer userId, String weixinUrl, String text, String voiceuri
            , String cdnImg, Integer voiceTime, String createTime) {
        this.mark = mark;
        this.userId = userId;
        this.weixinUrl = weixinUrl;
        this.text = text;
        this.voiceuri = voiceuri;
        this.cdnImg = cdnImg;
        this.voiceTime = voiceTime;
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

    public String getVoiceuri() {
        return voiceuri;
    }

    public void setVoiceuri(String voiceuri) {
        this.voiceuri = voiceuri;
    }

    public String getCdnImg() {
        return cdnImg;
    }

    public void setCdnImg(String cdnImg) {
        this.cdnImg = cdnImg;
    }

    public Integer getVoiceTime() {
        return voiceTime;
    }

    public void setVoiceTime(Integer voiceTime) {
        this.voiceTime = voiceTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VoiceBSBDJ{" +
                "id=" + id +
                ", mark=" + mark +
                ", userId=" + userId +
                ", weixinUrl='" + weixinUrl + '\'' +
                ", text='" + text + '\'' +
                ", voiceuri='" + voiceuri + '\'' +
                ", cdnImg='" + cdnImg + '\'' +
                ", voiceTime=" + voiceTime +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
