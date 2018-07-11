package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.JSONUtil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.gersion.library.base.BaseActivity;
import com.squareup.picasso.Picasso;


/**
 * Created by tlol20 on 2017/6/14
 */
public class SettingActivity extends BaseActivity {
    private TextView tv_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.rl_connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, ResetPwdActivity.class);
                //intent.putExtra("number",)

                startActivity(intent);
            }
        });
        tv_number=findViewById(R.id.tv_number);
       // goLogin();
        initView();
    }
    Context context=this;
    UserinfoBean userinfoBean;
    private void initView() {
        if (PreferencesUtils.getBoolean(this,"isLogin",false)) {
            userinfoBean= UserLocalData.getUser(this);
            tv_number.setText(userinfoBean.getUserPhone());

        }
    }

    private void goLogin() {
        HttpMethods.getInstance().loginWithAuthorization(new BaseObserver<UserInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                UserInfo houseDetil= (UserInfo) t;
                Log.d("onSuccees",houseDetil.getUserinfo());

                /*UserinfoBean userinfoBean= JSONUtil.fromJson(houseDetil.getUserinfo(),UserinfoBean.class);
                Log.d("onSuccees",userinfoBean.getUserName());

                UserLocalData.putUser(LoginActivity.this,userinfoBean);
                PreferencesUtils.putBoolean(LoginActivity.this,"isLogin",true);
                readyGo(IndexActivity_.class);
                LoginActivity.this.finish();*/


            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }
}
