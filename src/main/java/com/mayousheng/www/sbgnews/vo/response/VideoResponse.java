package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class VideoResponse extends BaseNewsResponse {

    private String videoUri;        //视频地址
    private String scImg;     //缩略图片
    private Integer width;      //宽
    private Integer height;     //高
    private Integer playTime;   //播放时长

    public VideoResponse() {
    }

    public VideoResponse(NewsDesc newsDesc, UserDesc userDesc
            , String text, String url, String videoUri, String scImg
            , Integer width, Integer height, Integer playTime) {
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
        setUrl(url);
        this.videoUri = videoUri;
        this.scImg = scImg;
        this.width = width;
        this.height = height;
        this.playTime = playTime;
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
}
