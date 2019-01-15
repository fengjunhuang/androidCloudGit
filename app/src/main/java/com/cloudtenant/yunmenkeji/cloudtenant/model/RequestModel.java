package com.cloudtenant.yunmenkeji.cloudtenant.model;

/**
 * Created by 72984 on 2019/1/9.
 */

public class RequestModel {

    String phone;

    public RequestModel(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
