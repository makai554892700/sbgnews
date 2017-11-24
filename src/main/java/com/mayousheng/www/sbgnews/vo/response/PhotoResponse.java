package com.mayousheng.www.sbgnews.vo.response;

import com.mayousheng.www.sbgnews.vo.response.base.BaseNewsResponse;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class PhotoResponse extends BaseNewsResponse {

    private String cdnImg;     //cdn图片地址

    public PhotoResponse() {
    }

    public PhotoResponse(String mark, NewsDesc newsDesc, UserDesc userDesc, String text, String url, String cdnImg) {
        setMark(mark);
        setNewsDesc(newsDesc);
        setUserDesc(userDesc);
        setText(text);
        setUrl(url);
        this.cdnImg = cdnImg;
    }

    public String getCdnImg() {
        return cdnImg;
    }

    public void setCdnImg(String cdnImg) {
        this.cdnImg = cdnImg;
    }

}
