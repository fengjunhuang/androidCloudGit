package com.cloudtenant.yunmenkeji.cloudtenant.model;

/**
 * Created by 72984 on 2018/7/23.
 */

public class LoginBean {
    private String userPhone;
    private String  userPassword;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public LoginBean(String userPhone, String userPassword) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }
}
