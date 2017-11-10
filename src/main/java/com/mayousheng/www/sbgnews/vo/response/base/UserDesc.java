package com.mayousheng.www.sbgnews.vo.response.base;

public class UserDesc {

    private String nickName;        //用户昵称
    private String imgUrl;         //用户头像

    public UserDesc() {
    }

    public UserDesc(String nickName, String imgUrl) {
        this.nickName = nickName;
        this.imgUrl = imgUrl;
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

    @Override
    public String toString() {
        return "UserDesc{" +
                "nickName='" + nickName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
