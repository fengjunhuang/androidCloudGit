package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.TimeCount;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.gersion.library.base.BaseActivity;
import com.mob.MobSDK;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ResetPwdActivity extends BaseActivity {

    Context mContext;
    private Button btnGetcode;

    private TimeCount time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        MobSDK.init(this);
        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                Log.d("afterEvent","event="+event+">>>result="+result+">>>>data="+data.toString());
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                HideView();
                            }
                        });
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ResetPwdActivity.this,"已发送验证码！", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(ResetPwdActivity.this,msg, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
        initData();

    }

    private void HideView() {
        one.setVisibility(View.GONE);
        commit.setVisibility(View.GONE);
        number.setVisibility(View.GONE);
        img.setVisibility(View.GONE);
        text.setVisibility(View.GONE);
        two.setVisibility(View.VISIBLE);
    }

    UserinfoBean userinfoBean;
    private Button commit,commit_pwd;
    private LinearLayout one,two;
    private String phone;
    private ImageView img;
    private TextView text,number;
    private void initData() {

        userinfoBean = UserLocalData.getUser(this);
        phone=userinfoBean.getUserPhone();
        btnGetcode = findViewById(R.id.btn_get_message);
        et_code=findViewById(R.id.et_code);
        one=findViewById(R.id.one);
        img=findViewById(R.id.img);
        text=findViewById(R.id.text);
        two=findViewById(R.id.two);
        number=findViewById(R.id.number);
        et_pwd=findViewById(R.id.et_pwd);
        et_pwd1=findViewById(R.id.et_pwd1);
        number.setText(phone.substring(0,3)+"****"+phone.substring(7,11));
        commit=findViewById(R.id.commit);
        commit_pwd=findViewById(R.id.commit_pwd);
        time = new TimeCount(60000, 1000,btnGetcode);
        btnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.start();
                getMsg();
            }
        });

        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et_code.getText().toString().trim();
                if (s.length()!=0){
                    SMSSDK.submitVerificationCode("86",phone,s);
                }else {
                    Toast.makeText(ResetPwdActivity.this, "请填写验证码！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        commit_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd=et_pwd.getText().toString();
                String pwd1=et_pwd1.getText().toString();
                if (pwd.equals(pwd1)) {
                    updatePassword(pwd);
                }else {
                    Toast.makeText(mContext, "2次密码不相同，请确认！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private EditText et_code,et_pwd,et_pwd1;
    private void getMsg() {
        SMSSDK.getVerificationCode("86", phone);
    }
    private void updatePassword(String pwd) {
        try {
            HttpMethods.getInstance().updatePassword(new BaseObserver<BrokenUp>() {
                @Override
                protected void onSuccees(BaseBean t) throws Exception {
                    BrokenUp houseDetil= (BrokenUp) t;
                    Log.e("getData","执行joinFamily方法返回"+houseDetil.getMessage());
                    Toast.makeText(ResetPwdActivity.this, houseDetil.getMessage(), Toast.LENGTH_SHORT).show();
                    //adapter.addAll(viewDataBeanList);
                    setResult(11);
                    PreferencesUtils.clear(ResetPwdActivity.this);
                    finish();
                }
                @Override
                protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                }
            },phone, AESOperator.getInstance().encrypt(pwd));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
