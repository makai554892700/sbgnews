package com.mayousheng.www.sbgnews.vo.response.base;

public class UserDesc {

    private String nikeName;        //用户昵称
    private String imgUrl;         //用户头像

    public UserDesc() {
    }

    public UserDesc(String nikeName, String imgUrl) {
        this.nikeName = nikeName;
        this.imgUrl = imgUrl;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
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
                "nikeName='" + nikeName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
