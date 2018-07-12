package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.util.TimeCount;
import com.gersion.library.base.BaseActivity;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ResetPwdActivity extends BaseActivity {


    private Button btnGetcode;

    private TimeCount time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);

        btnGetcode = findViewById(R.id.btn_get_message);
        time = new TimeCount(60000, 1000,btnGetcode);
        btnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.start();
            }
        });
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




}
