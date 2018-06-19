package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by 72984 on 2018/6/18.
 */
@EActivity
public class LoginActivity extends YzsBaseActivity {
    @Click(R.id.btn_login)
    void login(){


    }
    @Click(R.id.btn_visitor)
    void visitor(){
        readyGo(IndexActivity_.class);
    }

    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) {

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
