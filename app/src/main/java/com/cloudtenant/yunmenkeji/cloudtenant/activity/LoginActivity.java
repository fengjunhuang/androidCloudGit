package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 72984 on 2018/6/18.
 */
@EActivity
public class LoginActivity extends YzsBaseActivity {
    @Click(R.id.btn_login)
    void login(){
        HttpMethods.getInstance().homeData(new BaseObserver<HouseDetil>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                HouseDetil houseDetil= (HouseDetil) t;
                System.out.println(houseDetil.getViewDataX().size()+"");

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");

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
