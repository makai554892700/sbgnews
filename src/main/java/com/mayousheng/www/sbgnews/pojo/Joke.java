package com.mayousheng.www.sbgnews.pojo;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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

    @Column(nullable = false)
    private String ct;//数据创建时间

    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private Date created_at;

    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false)
    private Date updated_at;

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

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", ct='" + ct + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
//       {
//          "text": "我家隔壁有一对极品夫妻,结婚后吃干玩净贷款买车买房用负资产的方式拴住对方,两人的债还到60岁也还不完。谁要是想拆散他们得做好背几十年债的心里准备。神马海誓山盟都弱爆了,这才是保持爱情忠贞的好办法！",
//          "title": "保持爱情忠贞的好办法",
//          "type": 1,
//          "ct": "2017-09-29 09:30:16.135"
//       }