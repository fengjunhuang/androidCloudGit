package com.cloudtenant.yunmenkeji.cloudtenant.model;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.BaseBeanC;

public class StarAdModel extends BaseBeanC {
    private  String adDataUrl;
    private  String comName;
    private  String comYear;
    private  String adUrl;
    private  String message;

    public String getAdDataUrl() {
        return adDataUrl;
    }

    public void setAdDataUrl(String adDataUrl) {
        this.adDataUrl = adDataUrl;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComYear() {
        return comYear;
    }

    public void setComYear(String comYear) {
        this.comYear = comYear;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
