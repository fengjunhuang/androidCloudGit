package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
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
    private Switch s_message;
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
        findViewById(R.id.out_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(11);
                PreferencesUtils.clear(SettingActivity.this);
                finish();
            }
        });
        findViewById(R.id.rl_connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, ResetPwdActivity.class);
                //intent.putExtra("number",)
                startActivityForResult(intent,0);
            }
        });
        tv_number=findViewById(R.id.tv_number);
        s_message=findViewById(R.id.s_message);
        Log.e("getData","初始化 s="+PreferencesUtils.getString(context,"push","1"));

        if (!PreferencesUtils.getString(context,"push","1").equals("1")) {
            s_message.setChecked(false);
        }

        s_message.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    setPush("1");
                }else {
                    setPush("0");
                }
            }
        });
       // goLogin();
        initView();
    }

    private void setPush(final String s) {
                        Log.e("getData","执行joinFamily方法返回userPhone="+userPhone);
                        Log.e("getData","s="+s);

            try {
                HttpMethods.getInstance().upStatus(new BaseObserver<BrokenUp>() {
                    @Override
                    protected void onSuccees(BaseBean t) throws Exception {
                        BrokenUp houseDetil= (BrokenUp) t;
                        Log.e("getData","执行joinFamily方法返回"+houseDetil.getResult());
                        System.out.println(t.getMessage()+"");
                        PreferencesUtils.putString(SettingActivity.this,"push",s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                },userPhone, s,"2","","","","","","","");
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    Context context=this;
    UserinfoBean userinfoBean;
    String userPhone;
    private void initView() {
        if (PreferencesUtils.getBoolean(this,"isLogin",false)) {
            userinfoBean= UserLocalData.getUser(this);
            userPhone=userinfoBean.getUserPhone();
            tv_number.setText(userPhone);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult","requestCode="+requestCode+">>resultCode="+resultCode);
        if (resultCode==11){
            finish();
        }
    }
    private void goLogin() {
        /*HttpMethods.getInstance().loginWithAuthorization(new BaseObserver<UserInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                UserInfo houseDetil= (UserInfo) t;
                Log.d("onSuccees",houseDetil.getUserinfo());

                *//*UserinfoBean userinfoBean= JSONUtil.fromJson(houseDetil.getUserinfo(),UserinfoBean.class);
                Log.d("onSuccees",userinfoBean.getUserName());

                UserLocalData.putUser(LoginActivity.this,userinfoBean);
                PreferencesUtils.putBoolean(LoginActivity.this,"isLogin",true);
                readyGo(IndexActivity_.class);
                LoginActivity.this.finish();*//*


            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");*/
    }
}
