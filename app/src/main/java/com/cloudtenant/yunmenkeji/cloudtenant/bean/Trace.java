package com.cloudtenant.yunmenkeji.cloudtenant.bean;

public class Trace {
    @Override
    public String toString() {
        return "Trace{" +
                "acceptTime='" + acceptTime + '\'' +
                ", acceptStation='" + acceptStation + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    /** 时间 */
    private String acceptTime;
    /** 描述 */
    private String acceptStation;

    private String state;

    public Trace(String acceptTime, String acceptStation, String state) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
        this.state = state;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Trace() {
    }

    public Trace(String acceptTime, String acceptStation) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }
}

