package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.PayTask;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AuthResult;
import com.cloudtenant.yunmenkeji.cloudtenant.util.OrderInfoUtil2_0;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PayResult;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.Map;

/**
 * Created by 72984 on 2018/7/30.
 */

public class PayActivity extends YzsBaseActivity {
    /**
     * 用于支付宝支付业务的入参 app_id。
     */
    public static final String APPID = "2016092000553908";
    public static final String RSA2_PRIVATE = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDWWx7Lpy2qtdGaXZhjFtSR58EDie2QB+Ff/aSrZUPlvM23MFrJC6hRRuuzdb3ufgjQG8ngCDkolmUfr4GIQrC/g+jpVjJCbhTN8THADViPgJdWSoaaDnZo72wvjvRbk96IQ98EsFbyI0pK/mVqc7Ho1d0V/hJ/CYH0W9IADc7VSEPqCZG3F4lwXC+waeHA/KEHLkElr6kqwwtIhkY2xI+5zjAeWOrhbOIOnLgfC8zBPyumdb6mkDMWUEb+QQPQyvL4+tGCtdRc9gz54eAUC3JOa5/TkWQm4f8/8fixF4V/7s9+YJ6ye/Mcij5IX+9JZ/gUD/5R7vJj9VJvgjGatD3XAgMBAAECggEAKqTqFX3m2eVeE6W3IU9zbqt6fKe9+T94GM6vKeH1hgjvrBgUl5aYH8NKNOOhq4arXiuJF+bK6EYzTABwdpk97HvjpDgfu5OG1Am96gU9rx7X/LTK3m8uI2YuUa/Q8T8TsGxAPACQ648VwqGlr23g4P9bAnsPVvKfRevWdWhJ06g1cf1CpE3XXoUsZZN7BLoZ5Uoq9TNA4B0TGMMWh05/ajWEqUB5NuQp4RNcT08M750ih1p0xfu/ThpFmB4JT46Q5oBKdPZtDpt77jwBtdwLgu84TdGFbXz3jdDK1t7bVUIPWmavS5iguO6QTpWaAd59Yx85UXnhSMDJ0BUndZz7EQKBgQD3ad2yU9VgxJbWuyL52IHLr8hkVxYqLD5shBYYnV1JYHEEzsbWmrEDOMvP2OTeFa5iHHe4niciHbWcBVzicHB4Oq3cUb3r9SiSXIhtrQTSC8bcM4B8pQx+n+HC9kPx2DqhPdEwnoynLiGaZgNcxUvmdwPubIPpMP3Iq9X5KgCM3QKBgQDdy447K3xc+KaKvM8zJSE1F9uqyihvzyjcsvWhhBlZa5sovj//ASjyaBJh1xwMvOHWXuTZX9qmCtVr5bIIhs0PUcZSbrj1OfbRzJecstxYQm7ShwPrun4bSzHF0UFpFZe8wNqjPmMOy/uubN46zDMEWQ8d0r3NQsqQJfI1UqbgQwKBgCgKG/S2GHwWlIqfsmNYpHjAM9/5L/8XNer93U2Sefxb/S5YAFnOowLweBtk8HT4cUYzcTSRc6fTwwZC3+tNYwYyCNz05ZWAEVbOXs3RCEyt1zrfotWJKGJ9oV2Z2RkUcziQ9n+1yPFtR8bi53xl+YiMjjhRm29rnEaTeIdgQsKJAoGBANVM9O08pe53hxr398B1HdmEp1I59ueIcADH7ug1NXfEv8RQKxWf1PRDWCJWEHjDkeFrA2V2BL4YvyV0EmKW2VC5USRnrWLRKuibfNdLQBN1WEUJaaDjinHPP//BfcmE5Ze2VM4XqoZJcDNQKeycAxhUWfBRgw2LBWnZxHS5lxknAoGBALV0zHYuo5nkZNsO6ivlFEc5Foqy1oP4IDRm53iQ+sAJ7diQdswAXmKpLu08A+50ghBtxL7XQoqIenbodLXiG8cTMCYR2P5kHwSQYXzvxF1nJF6sykMdf5/GLi+01Z2lS8dIDcSwIedMIATIqcp6H2Mx1CPKGLcKGEe7rsVOAVbT";
    public static final String RSA_PRIVATE = "";
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依    赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(PayActivity.this,  "支付成功: " + payResult, Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(PayActivity.this,  "支付失败: " + payResult, Toast.LENGTH_SHORT).show();
                        Log.d("PayActivity","支付失败: " +payResult);
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(PayActivity.this,  "授权成功: " + authResult, Toast.LENGTH_SHORT).show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(PayActivity.this,  "授权失败: " + authResult, Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };
    @Override
    protected void initContentView(Bundle var1) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        setContentView(R.layout.activity_pay);
    }

    @Override
    protected void initView() {
        findViewById(R.id.out).setVisibility(View.VISIBLE);
        setMainText("收款台");
        getBtn1().setVisibility(View.INVISIBLE);
        getBtn2().setVisibility(View.INVISIBLE);
        getTv_smell().setVisibility(View.GONE);
        findViewById(R.id.btn_guide_enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(RSA_PRIVATE))) {
                        Toast.makeText(PayActivity.this,  "错误: 需要配置 PayDemoActivity 中的 APPID 和 RSA_PRIVATE", Toast.LENGTH_SHORT).show();
                    return;
                }

                /*
                 * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
                 * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
                 * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
                 *
                 * orderInfo 的获取必须来自服务端；
                 */
                boolean rsa2 = (RSA2_PRIVATE.length() > 0);
                Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
                String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

                String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
                String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
                final String orderInfo = orderParam + "&" + sign;

                Runnable payRunnable = new Runnable() {

                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(PayActivity.this);
                        Map<String, String> result = alipay.payV2(orderInfo, true);
                        Log.i("msp", result.toString());

                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };

                Thread payThread = new Thread(payRunnable);
                payThread.start();
            }
        });
    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) throws Exception {

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
