package com.cloudtenant.yunmenkeji.cloudtenant.bean;

public class Sensor {
    private String time;
    private String date;

    public String getTime() {
        return time;
    }

    public Sensor(String time, String date) {
        this.time = time;
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
