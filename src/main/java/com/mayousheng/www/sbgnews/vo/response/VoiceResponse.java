package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class VoiceResponse extends BaseNewsResponse {

    private String voiceuri;        //声音url
    private String cdnImg;            //cdn图片(缩放)

    public VoiceResponse() {
    }

    public VoiceResponse(Integer mark, NewsDesc newsDesc, UserDesc userDesc, String text
            , String url, String voiceuri, String cdnImg) {
        setMark(mark);
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
        setUrl(url);
        this.voiceuri = voiceuri;
        this.cdnImg = cdnImg;
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
}
