package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import android.util.Log;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;

/**
 * Created by 72984 on 2018/12/16.
 */

public class BaseBeanC extends BaseBean {
    private  String viewData;

    public String getViewData() throws Exception {
        //Log.e("BaseBeanC",AESOperator.getInstance().decrypt(viewData));
        return AESOperator.getInstance().decrypt(viewData);
    }

    public void setViewData(String viewData) throws Exception {
        this.viewData = viewData;

    }
}
