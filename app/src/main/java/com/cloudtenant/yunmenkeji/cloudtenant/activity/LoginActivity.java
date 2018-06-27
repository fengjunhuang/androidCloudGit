package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by 72984 on 2018/6/18.
 */
@EActivity
public class LoginActivity extends YzsBaseActivity implements View.OnClickListener {
    @Click(R.id.btn_login)
    void login(){
        HttpMethods.getInstance().login(new BaseObserver<String>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                System.out.println(t);

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                System.out.println(e);
        }

            @Override
            public void onNext(BaseBean baseBean) {
                System.out.println("");
            }
        },"");

    }
    @Click(R.id.btn_visitor)
    void visitor(){
        readyGo(IndexActivity_.class);
    }
    private LinearLayout ll_one,ll_two;
    private TextView pwd_login,msg_login;
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_login);
        pwd_login=findViewById(R.id.pwd_login);
        pwd_login.setOnClickListener(this);
        msg_login=findViewById(R.id.msg_login);
        msg_login.setOnClickListener(this);
        ll_one=findViewById(R.id.one);
        ll_two=findViewById(R.id.two);
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

    @Override
    public void onClick(View view) {
        ll_one.setVisibility(View.GONE);
        ll_two.setVisibility(View.GONE);
        msg_login.setTextColor(Color.GRAY);
        pwd_login.setTextColor(Color.GRAY);
        switch (view.getId()){

            case R.id.msg_login:{
                ll_one.setVisibility(View.VISIBLE);
                msg_login.setTextColor(getResources().getColor(R.color.gren_cut_clorr));
            }break;
            case R.id.pwd_login:{
                pwd_login.setTextColor(getResources().getColor(R.color.gren_cut_clorr));
                ll_two.setVisibility(View.VISIBLE);
            }break;
        }
    }
}
