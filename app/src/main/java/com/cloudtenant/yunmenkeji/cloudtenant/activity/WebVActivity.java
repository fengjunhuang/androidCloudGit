package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.gersion.library.base.BaseActivity;
import com.just.library.AgentWeb;


/**
 * Created by tlol20 on 2017/6/14
 */
public class WebVActivity extends BaseActivity {

    private LinearLayout mldzChufanginfoWeblayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webv);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mldzChufanginfoWeblayout=(LinearLayout)findViewById(R.id.mldz_chufanginfo_weblayout) ;
        String s=getIntent().getStringExtra("url");
        AgentWeb mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(mldzChufanginfoWeblayout, new LinearLayout.LayoutParams(-1, -1))
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .createAgentWeb()//
                .ready()
                .go("http://"+s+"/");


    }
}
