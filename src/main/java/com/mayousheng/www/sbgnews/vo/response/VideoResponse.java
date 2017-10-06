package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class VideoResponse extends BaseNewsResponse {

    private String videoUri;        //视频地址

    public VideoResponse() {
    }

    public VideoResponse(Integer mark, NewsDesc newsDesc, UserDesc userDesc, String text, String videoUri) {
        setMark(mark);
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
        this.videoUri = videoUri;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}
