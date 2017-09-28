package com.mayousheng.www.sbgnews.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//头条新闻对象
@Entity
public class TopNews {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true)
    private String uniquekey;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String author_name;

    @Column(nullable = false)
    private String url;

    private String thumbnail_pic_s;

    private String thumbnail_pic_s02;

    private String thumbnail_pic_s03;

    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private Date created_at;

    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false)
    private Date updated_at;

    @Column(nullable = false)
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TopNews{" +
                "id=" + id +
                ", uniquekey='" + uniquekey + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", author_name='" + author_name + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", type='" + type + '\'' +
                '}';
    }
}
//    "uniquekey": "8bc64995d19b787a403164e5d9097d14",
//            "title": "司机驾车途中闻到一股糊味，停车检查发现轮胎中卡着一只国宝",
//            "date": "2017-09-26 21:19",
//            "category": "头条",
//            "author_name": "透透世道",
//            "url": "http://mini.eastday.com/mobile/170926211958961.html",
//            "thumbnail_pic_s": "http://02.imgmini.eastday.com/mobile/20170926/20170926_5503ef6b822e3008bd6c62dd4713f07a_cover_mwpm_03200403.jpg",
//            "thumbnail_pic_s02": "http://02.imgmini.eastday.com/mobile/20170926/20170926_285027748d928f5bde39a55c705ff6ea_cover_mwpm_03200403.jpg",
//            "thumbnail_pic_s03": "http://02.imgmini.eastday.com/mobile/20170926/20170926_45b8b67db5a9f28632c54743992b20e9_cover_mwpm_03200403.jpg"

