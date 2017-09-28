package com.mayousheng.www.sbgnews.vo.response;

public class TopNewsResponse {

    private String type;//新闻类型
    private String title;//新闻标题
    private String date;//新闻发布日期
    private String authorName;//作者
    private String url;//新闻详情地址
    private String picture01;//新闻图片1
    private String picture02;//新闻图片2
    private String picture03;//新闻图片3

    public TopNewsResponse() {
    }

    public TopNewsResponse(String type, String title, String date, String authorName, String url,
                           String picture01, String picture02, String picture03) {
        this.type = type;
        this.title = title;
        this.date = date;
        this.authorName = authorName;
        this.url = url;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicture01() {
        return picture01;
    }

    public void setPicture01(String picture01) {
        this.picture01 = picture01;
    }

    public String getPicture02() {
        return picture02;
    }

    public void setPicture02(String picture02) {
        this.picture02 = picture02;
    }

    public String getPicture03() {
        return picture03;
    }

    public void setPicture03(String picture03) {
        this.picture03 = picture03;
    }

    @Override
    public String toString() {
        return "TopNewsResponse{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", authorName='" + authorName + '\'' +
                ", url='" + url + '\'' +
                ", picture01='" + picture01 + '\'' +
                ", picture02='" + picture02 + '\'' +
                ", picture03='" + picture03 + '\'' +
                '}';
    }
}
