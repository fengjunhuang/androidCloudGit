package com.cloudtenant.yunmenkeji.cloudtenant.model;

/**
 * Created by 72984 on 2018/7/23.
 */

public class LoginBean {
    private String userPhone;
    private String  type ;
    private String  password ;

    public LoginBean(String userPhone, String type, String password, boolean isLogin, String registrationID) {
        this.userPhone = userPhone;
        this.type = type;
        this.password = password;
        this.isLogin = isLogin;
        this.registrationID = registrationID;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    private boolean  isLogin ;
    private String  registrationID ;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    /*public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }*/

    public LoginBean(String userPhone, String type) {
        this.userPhone = userPhone;
        this.type = type;
    }
    public LoginBean(String type) {
        this.type = type;
    }
}
