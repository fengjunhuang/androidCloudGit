package com.cloudtenant.yunmenkeji.cloudtenant.model;

import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;

import java.io.Serializable;

/**
 * Created by feng on 2017/12/19.
 */

public class BaseBean implements Serializable {


    /**
     * result : true
     * message : 修改成功
     */

    private String result;
    private String message;
    private  String viewData;

    public String getViewData() throws Exception {
        return AESOperator.getInstance().decrypt(viewData);
    }

    public void setViewData(String viewData) throws Exception {
        this.viewData = viewData;

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
