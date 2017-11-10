package com.mayousheng.www.sbgnews.vo.response;

public class UserResponse {

    private String userName;        //账户	String(unique)
    private String nickName;        //昵称	String
    private Integer sex;            //性别	int
    private String msg;             //个性签名	String
    private String email;           //邮箱	String
    private String phone;           //电话号码	String
    private String imgUrl;          //头像图片url	String
    private String pageHome;        //主页链接	String

    public UserResponse() {
    }

    public UserResponse(String userName, String nickName, Integer sex, String msg, String email
            , String phone, String imgUrl, String pageHome) {
        this.userName = userName;
        this.nickName = nickName;
        this.sex = sex;
        this.msg = msg;
        this.email = email;
        this.phone = phone;
        this.imgUrl = imgUrl;
        this.pageHome = pageHome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "UserResponse{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", msg='" + msg + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", pageHome='" + pageHome + '\'' +
                '}';
    }
}
