package com.cloudtenant.yunmenkeji.cloudTenant.model;

import java.io.Serializable;

/**
 * Created by feng on 2017/12/19.
 */

public class BaseBean implements Serializable{
    private int result;
    private String error;
    private int code;
    public  boolean isSuccess(){
        return  result==1;


    }
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
