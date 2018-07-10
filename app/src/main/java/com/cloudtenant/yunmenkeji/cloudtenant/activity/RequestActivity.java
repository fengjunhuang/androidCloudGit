package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.gersion.library.base.BaseActivity;



/**
 * Created by tlol20 on 2017/6/14
 */
public class RequestActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
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
        TextView tvOpinion=findViewById(R.id.tv_opinion);
        tvOpinion.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

    }
}
