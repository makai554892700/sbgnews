package com.mayousheng.www.sbgnews.pojo;


import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "userId,descId,tableName")})
public class Love {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Integer userId;            //用户id	int(unique)
    @Column(nullable = false)
    private Integer descId;            //表数据id	int(unique)
    @Column(nullable = false)
    private String tableName;        //表名		String(unique)

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

    @Override
    public String toString() {
        return "Love{" +
                "id=" + id +
                ", userId=" + userId +
                ", descId=" + descId +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
