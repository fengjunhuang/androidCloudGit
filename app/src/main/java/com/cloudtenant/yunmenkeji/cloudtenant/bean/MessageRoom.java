package com.cloudtenant.yunmenkeji.cloudtenant.bean;

public class MessageRoom {
    private String Family;
    private String Time;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public MessageRoom(String family, String time) {
        Family = family;
        Time = time;

    }

    public MessageRoom(String family) {
        Family = family;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }
}
