package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.zph.glpanorama.GLPanorama;

/**
 * Created by 72984 on 2018/6/24.
 */

public class OnlineVisitAcivity extends YzsBaseActivity {
   private GLPanorama  mGLPanorama;
    @Override
    protected void initContentView(Bundle var1) {
     setContentView(R.layout.activity_online_visit);
    }

    @Override
    protected void initView() {
        mGLPanorama= (GLPanorama) findViewById(R.id.mGLPanorama);
        //传入你的全景图
        mGLPanorama.setGLPanorama(R.drawable.quanjin);
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
}
