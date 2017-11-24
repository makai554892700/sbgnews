package com.mayousheng.www.sbgnews.pojo.joke;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//笑话对象
@Entity
public class Joke {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    @Type(type = "text")
    private String text;
    @Column(nullable = false, unique = true)
    private String title;
    private Integer userId;
    @Column(nullable = false)
    private String ct;//数据创建时间

    public Joke() {
    }

    public Joke(String text, String title,  Integer userId, String ct) {
        this.text = text;
        this.title = title;
        this.userId = userId;
        this.ct = ct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", ct='" + ct + '\'' +
                '}';
    }
}