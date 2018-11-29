package com.cloudtenant.yunmenkeji.cloudtenant.model;

/**
 * Created by 72984 on 2018/7/23.
 */

public class ListBean {
    private String page;
    private String row;
    private String longitdue;
    private String latitude;

    public ListBean(String page, String row, String longitdue, String latitude) {
        this.page = page;
        this.row = row;
        this.longitdue = longitdue;
        this.latitude = latitude;
    }

    public String getPage() {

        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getLongitdue() {
        return longitdue;
    }

    public void setLongitdue(String longitdue) {
        this.longitdue = longitdue;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
