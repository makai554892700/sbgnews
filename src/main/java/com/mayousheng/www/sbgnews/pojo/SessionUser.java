package com.mayousheng.www.sbgnews.pojo;

import java.io.Serializable;

public class SessionUser implements Serializable {

    private Integer id;
    private String userName;

    public SessionUser() {
    }

    public SessionUser(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
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

    @Override
    public String toString() {
        return "SessionUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
