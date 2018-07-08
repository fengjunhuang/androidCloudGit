package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.view.View;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.gersion.library.base.BaseActivity;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ResetPwdActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
