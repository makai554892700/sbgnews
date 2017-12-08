package com.mayousheng.www.sbgnews.pojo.operate;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "userId,descId,tableName")})
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Integer userId;            //用户id	int(unique)
    @Column(nullable = false)
    private Integer descId;            //表数据id	int(unique)
    @Column(nullable = false)
    private String tableName;        //表名		String(unique)
    @Column(nullable = false)
    @Type(type = "text")
    private String info;        //评论信息		String

    public Comment() {
    }

    public Comment(Integer userId, Integer descId, String tableName, String info) {
        this.userId = userId;
        this.descId = descId;
        this.tableName = tableName;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDescId() {
        return descId;
    }

    public void setDescId(Integer descId) {
        this.descId = descId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", descId=" + descId +
                ", tableName='" + tableName + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
