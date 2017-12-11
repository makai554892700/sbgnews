package com.mayousheng.www.sbgnews.vo.response.base;

public class UserDesc {

    private String nickName;        //用户昵称
    private String imgUrl;         //用户头像
    private String pageHome;        //主页链接	String

    public UserDesc() {
    }

    public UserDesc(String nickName, String imgUrl, String pageHome) {
        this.nickName = nickName;
        this.imgUrl = imgUrl;
        this.pageHome = pageHome;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPageHome() {
        return pageHome;
    }

    public void setPageHome(String pageHome) {
        this.pageHome = pageHome;
    }

    @Override
    public String toString() {
        return "UserDesc{" +
                "nickName='" + nickName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", pageHome='" + pageHome + '\'' +
                '}';
    }
}
