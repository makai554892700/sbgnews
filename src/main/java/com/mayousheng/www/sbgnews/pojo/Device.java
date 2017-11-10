package com.mayousheng.www.sbgnews.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(columnList = "manufacturer,model,versionCode")})
public class Device {

    @Id
    @GeneratedValue
    private Integer id;
    private String imei;            //唯一码(不一定能拿到)	String
    @Column(nullable = false, unique = true)
    private String androidId;       //设备码(百分百存在，作为唯一标识)	String(unique)
    private String wifiMac;         //wifi的mac地址	String
    private Integer width;           //宽	int
    private Integer height;          //高	int
    private String manufacturer;    //品牌	String(index)
    private String model;           //型号	String(index)
    private Integer versionCode;     //Android版本	int(index)
    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date createdAt;
    @Column(columnDefinition = "TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getWifiMac() {
        return wifiMac;
    }

    public void setWifiMac(String wifiMac) {
        this.wifiMac = wifiMac;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
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
        return "Device{" +
                "id='" + id + '\'' +
                ", imei='" + imei + '\'' +
                ", androidId='" + androidId + '\'' +
                ", wifiMac='" + wifiMac + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", versionCode=" + versionCode +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
