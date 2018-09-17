package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import java.io.Serializable;

public class RoomMoreImageArrBean implements Serializable {
    public RoomMoreImageArrBean(String imageTitle, String imageInfo, String imageFullView, String imageUrl) {
        this.imageTitle = imageTitle;
        this.imageInfo = imageInfo;
        this.imageFullView = imageFullView;
        this.imageUrl = imageUrl;
    }

    /**
     * imageTitle : 房间全景照
     * imageInfo : 房间非常舒适
     * imageFullView : 1
     * imageUrl : https://theta360cn.com/cn/gallery/img/v_04.jpg
     */

    private String imageTitle;
    private String imageInfo;
    private String imageFullView;
    private String imageUrl;

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(String imageInfo) {
        this.imageInfo = imageInfo;
    }

    public String getImageFullView() {
        return imageFullView;
    }

    public void setImageFullView(String imageFullView) {
        this.imageFullView = imageFullView;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
