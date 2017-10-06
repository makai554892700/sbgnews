package com.mayousheng.www.sbgnews.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private String userName;        //账户	String(unique)
    private String nickName;        //昵称	String
    private Integer sex;            //性别	int
    private String msg;             //个性签名	String
    private String passWord;        //密码	String
    private String email;           //邮箱	String
    private String phone;           //电话号码	String
    private String imgUrl;          //头像图片url	String
    private String pageHome;        //主页链接	String
    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private Date createdAt;
    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false)
    private Date updatedAt;

    public User() {
    }

    public User(String userName, String nickName, Integer sex, String msg, String passWord, String email
            , String phone, String imgUrl, String pageHome) {
        this.userName = userName;
        this.nickName = nickName;
        this.sex = sex;
        this.msg = msg;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.imgUrl = imgUrl;
        this.pageHome = pageHome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", msg='" + msg + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", pageHome='" + pageHome + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
