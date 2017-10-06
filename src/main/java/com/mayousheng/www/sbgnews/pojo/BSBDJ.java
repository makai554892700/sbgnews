package com.mayousheng.www.sbgnews.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class BSBDJ {

    private String text;
    private Integer hate;
    private String weixinUrl;
    private String profileImage;
    private String cdnImg;
    private String ct;
    private Integer id;
    private Integer love;
    private String _id;
    private String voiceUri;
    private String videoUri;
    private String name;
    private String createTime;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getHate() {
        return hate;
    }

    public void setHate(Integer hate) {
        this.hate = hate;
    }

    public String getWeixinUrl() {
        return weixinUrl;
    }

    public void setWeixinUrl(String weixinUrl) {
        this.weixinUrl = weixinUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCdnImg() {
        return cdnImg;
    }

    public void setCdnImg(String cdnImg) {
        this.cdnImg = cdnImg;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public Integer getId() {
        return id;
    }

    @JSONField(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public String get_id() {
        return _id;
    }

    @JSONField(name = "_id")
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getVoiceUri() {
        return voiceUri;
    }

    public void setVoiceUri(String voiceUri) {
        this.voiceUri = voiceUri;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BSBDJ{" +
                "text='" + text + '\'' +
                ", hate=" + hate +
                ", weixinUrl='" + weixinUrl + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", cdnImg='" + cdnImg + '\'' +
                ", ct='" + ct + '\'' +
                ", id=" + id +
                ", love=" + love +
                ", _id='" + _id + '\'' +
                ", voiceUri='" + voiceUri + '\'' +
                ", videoUri='" + videoUri + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
