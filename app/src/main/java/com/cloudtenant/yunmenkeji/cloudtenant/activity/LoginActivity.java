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
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
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
import com.tsy.sdk.social.PlatformType;
import com.tsy.sdk.social.SocialApi;
import com.tsy.sdk.social.listener.AuthListener;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import java.util.Map;
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
    private boolean isPwdLogin=false;
    private String pwd;
    private SpotsDialog mDialog;
    private SocialApi mSocialApi;


    @Click(R.id.btn_login)
    void login(){

        //goLogin();
        phone=et_number.getText().toString();
        if (checkPhoneNum(phone,"86")) {
            if (!isPwdLogin){
                    mDialog.show();
                    SMSSDK.submitVerificationCode("86",phone,et_code.getText().toString().trim());

            }else {
                pwd=et_pwd.getText().toString().trim();
                if (pwd!=null&&pwd!=""){
                    pwdLogin();
                }else {
                    Toast.makeText(this, "密码不能为空！！", Toast.LENGTH_SHORT).show();
                }
            }
        }
        /**/
    }

    private void pwdLogin() {
        try {
            HttpMethods.getInstance().login(new BaseObserver<UserInfo>() {
                @Override
                protected void onSuccees(BaseBean t) throws Exception {

                    //Toast.makeText(LoginActivity.this, "登陆成功！！", Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                    Log.d("onSuccess","message="+t.getMessage());

                    if (t.getResult().equals("false")) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        UserInfo houseDetil= (UserInfo) t;
                        String s=houseDetil.getUserinfo().replace("[","");
                        String s1=s.replace("]","");
                        //String s1=s.substring(0,s.length()-1);
                        Log.d("onSuccess",houseDetil.getUserinfo());
                        Log.d("onSuccess","截取后的字段="+s1);
                        UserinfoBean userinfoBean= JSONUtil.fromJson(s1,UserinfoBean.class);
                        Log.d("onSuccees",userinfoBean.getUserName());
                        Log.d("onSuccees",userinfoBean.toString());

                        UserLocalData.putUser(LoginActivity.this,userinfoBean);

                        PreferencesUtils.putBoolean(LoginActivity.this,"isLogin",true);

                        Log.d("onSuccees","isLogin="+PreferencesUtils.getBoolean(LoginActivity.this,"isLogin"));
                        readyGo(IndexActivity_.class);
                        LoginActivity.this.finish();
                    }


                }
                @Override
                protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                    Log.d("goLogin","网络状态》》"+isNetWorkError+"!!"+e.getMessage());

                }
            },"2",phone,AESOperator.getInstance().encrypt(pwd),true,"");
        } catch (Exception e) {
            e.printStackTrace();
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
    private EditText et_number,et_code,et_pwd;
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_login);
        mDialog=new SpotsDialog(this);
        pwd_login=findViewById(R.id.pwd_login);
        et_number=findViewById(R.id.et_number);
        et_pwd=findViewById(R.id.et_pwd);
        et_code=findViewById(R.id.et_code);
        findViewById(R.id.tx_fg_pwd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readyGo(ResetPwdActivity.class);
            }
        });
        et_number.setText("13068893276");
        et_pwd.setText("123456");
        pwd_login.setOnClickListener(this);
        msg_login=findViewById(R.id.msg_login);
        msg_login.setOnClickListener(this);
        ll_one=findViewById(R.id.one);
        ll_two=findViewById(R.id.two);

        mSocialApi = SocialApi.get(getApplicationContext());

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
    /**
     * 微信登录
     */
    @Click(R.id.iv_wechat)
    public void onWXLogin() {
        mSocialApi.doOauthVerify(this, PlatformType.WEIXIN , new MyAuthListener());
    }

    /**
     * qq登录
     */
    @Click(R.id.iv_qq)
    public void onQQLogin() {
        mSocialApi.doOauthVerify(this, PlatformType.QQ, new MyAuthListener());
    }

    /**
     * 新浪微博登录
     */
    @Click(R.id.iv_sina)
    public void onSinaWBLogin() {
        mSocialApi.doOauthVerify(this, PlatformType.SINA_WB, new MyAuthListener());
    }
    public class MyAuthListener implements AuthListener {
        @Override
        public void onComplete(PlatformType platform_type, Map<String, String> map) {
            Toast.makeText(LoginActivity.this, platform_type + " login onComplete", Toast.LENGTH_SHORT).show();
            Log.i("tsy", "login onComplete:" + map);
            int type=0;
            if(platform_type==PlatformType.WEIXIN){
                type=1;

            }
            HttpMethods.getInstance().checkAuthorization(new BaseObserver<UserInfo>() {
                @Override
                protected void onSuccees(BaseBean t) throws Exception {

                    UserInfo houseDetil= (UserInfo) t;
                    if(houseDetil.getResult().equals("true")){
                    Log.d("onSuccess",houseDetil.getUserinfo());
                    String s=houseDetil.getUserinfo().substring(1,houseDetil.getUserinfo().length());
                    String s1=s.substring(0,s.length()-1);

                    Log.d("onSuccess","截取后的字段="+s1);
                    UserinfoBean userinfoBean= JSONUtil.fromJson(s1,UserinfoBean.class);
                    Log.d("onSuccees",userinfoBean.getUserName());

                    UserLocalData.putUser(LoginActivity.this,userinfoBean);
                    PreferencesUtils.putBoolean(LoginActivity.this,"isLogin",true);
                    readyGo(IndexActivity_.class);
                    LoginActivity.this.finish();
                    }else {
                        //手机未绑定

                    }

                }

                @Override
                protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                }
            },type+"","2222","","","","","","","");

        }

        @Override
        public void onError(PlatformType platform_type, String err_msg) {
            Toast.makeText(LoginActivity.this, platform_type + " login onError:" + err_msg, Toast.LENGTH_SHORT).show();
            Log.i("tsy", "login onError:" + err_msg);
        }

        @Override
        public void onCancel(PlatformType platform_type) {
            Toast.makeText(LoginActivity.this, platform_type + " login onCancel", Toast.LENGTH_SHORT).show();
            Log.i("tsy", "login onCancel");
        }
    }
    private void goLogin() {

        Log.d("goLogin","电话号码=="+phone);
        HttpMethods.getInstance().login(new BaseObserver<UserInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                mDialog.dismiss();
                UserInfo houseDetil= (UserInfo) t;
                    Log.d("onSuccess",houseDetil.getUserinfo());
                String s=houseDetil.getUserinfo().substring(1,houseDetil.getUserinfo().length());
                String s1=s.substring(0,s.length()-1);

                    Log.d("onSuccess","截取后的字段="+s1);
                UserinfoBean userinfoBean= JSONUtil.fromJson(s1,UserinfoBean.class);
                    Log.d("onSuccees",userinfoBean.getUserName());

                    UserLocalData.putUser(LoginActivity.this,userinfoBean);
                    PreferencesUtils.putBoolean(LoginActivity.this,"isLogin",true);
                    readyGo(IndexActivity_.class);
                    LoginActivity.this.finish();


            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                    Log.d("goLogin","网络状态》》"+isNetWorkError+"!!"+e.getMessage());

            }
        },1+"",phone);
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
                isPwdLogin=false;
                ll_one.setVisibility(View.VISIBLE);
                msg_login.setTextColor(getResources().getColor(R.color.gren_cut_clorr));
            }break;
            case R.id.pwd_login:{
                isPwdLogin=true;
                pwd_login.setTextColor(getResources().getColor(R.color.gren_cut_clorr));
                ll_two.setVisibility(View.VISIBLE);
            }break;
        }
    }
}
