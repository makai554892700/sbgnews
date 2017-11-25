package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class PhotoResponse extends BaseNewsResponse {

    private String cdnImg;     //cdn图片地址
    private String scImg;     //缩略图片
    private Integer width;      //宽
    private Integer height;     //高

    public PhotoResponse() {
    }

    public PhotoResponse(NewsDesc newsDesc, UserDesc userDesc
            , String text, String url, String cdnImg, String scImg
            , Integer width, Integer height) {
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
        setUrl(url);
        this.cdnImg = cdnImg;
        this.scImg = scImg;
        this.width = width;
        this.height = height;
    }

    public String getCdnImg() {
        return cdnImg;
    }

    public void setCdnImg(String cdnImg) {
        this.cdnImg = cdnImg;
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
}
