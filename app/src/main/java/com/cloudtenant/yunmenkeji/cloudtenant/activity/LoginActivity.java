package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BuildingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.LoginBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.JSONUtil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.TimeCount;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.mob.MobSDK;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;
import dmax.dialog.SpotsDialog;


/**
 * Created by 72984 on 2018/6/18.
 */
@EActivity
public class LoginActivity extends YzsBaseActivity implements View.OnClickListener {
    private SpotsDialog mDialog;
    @Click(R.id.btn_login)
    void login(){
        if (checkPhoneNum(et_number.getText().toString().trim(),"86")) {


        mDialog.show();
        SMSSDK.submitVerificationCode("86",phone,et_code.getText().toString().trim());
//        goLogin();
        }
    }
    @Click(R.id.btn_visitor)
    void visitor(){
        readyGo(IndexActivity_.class);
    }
    private LinearLayout ll_one,ll_two;
    private TextView pwd_login,msg_login;

    private Button btnGetcode;
    private TimeCount timeCount;
    private EventHandler eventHandler;
    private EditText et_number,et_code;
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_login);
        mDialog=new SpotsDialog(this);
        pwd_login=findViewById(R.id.pwd_login);
        et_number=findViewById(R.id.et_number);
        et_code=findViewById(R.id.et_code);
        findViewById(R.id.tx_fg_pwd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readyGo(ResetPwdActivity.class);
            }
        });
        pwd_login.setOnClickListener(this);
        msg_login=findViewById(R.id.msg_login);
        msg_login.setOnClickListener(this);
        ll_one=findViewById(R.id.one);
        ll_two=findViewById(R.id.two);

        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        MobSDK.init(this);
        //SMSSDK.setAskPermisionOnReadContact(true);


        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                Log.d("afterEvent","event="+event+">>>result="+result+">>>>data="+data.toString());
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        goLogin();
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this,"已发送验证码！", Toast.LENGTH_LONG).show();
                            }
                        });
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();

                    Throwable throwable = (Throwable)data;
                    final String msg = throwable.getMessage();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("afterEvent","msg="+msg);
                            Toast.makeText(LoginActivity.this,msg, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调



        btnGetcode = findViewById(R.id.btn_get_message);
        timeCount = new TimeCount(60000, 1000,btnGetcode);
        btnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone=et_number.getText().toString().trim();
                if (checkPhoneNum(phone,"+86")) {
                    Log.e("onSendMessage","phone="+phone);
                    timeCount.start();
                    SMSSDK.getVerificationCode("86", phone);
                }

            }
        });

    }

    private void goLogin() {
        HttpMethods.getInstance().login(new BaseObserver<UserInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                mDialog.dismiss();
                UserInfo houseDetil= (UserInfo) t;
                    Log.d("onSuccees",houseDetil.getUserinfo());

                UserinfoBean userinfoBean= JSONUtil.fromJson(houseDetil.getUserinfo(),UserinfoBean.class);
                    Log.d("onSuccees",userinfoBean.getUserName());

                    UserLocalData.putUser(LoginActivity.this,userinfoBean);
                    PreferencesUtils.putBoolean(LoginActivity.this,"isLogin",true);
                    readyGo(IndexActivity_.class);
                    LoginActivity.this.finish();


            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },new LoginBean("aaaa","aaaaaaaaaaa"));
    }

    private String phone;
    private boolean checkPhoneNum(String phone, String code) {

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(LoginActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phone.length() != 11) {
            Toast.makeText(LoginActivity.this, "手机号码长度不对", Toast.LENGTH_SHORT).show();
            return false;
        }


            String rule = "^1(3|5|7|8|4|6)\\d{9}";
            Pattern p = Pattern.compile(rule);
            Matcher m = p.matcher(phone);

            if (!m.matches()) {
                Toast.makeText(LoginActivity.this, "您输入的手机号码格式不正确", Toast.LENGTH_SHORT).show();
                return false;
            }else {

                return true;
            }
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
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
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
