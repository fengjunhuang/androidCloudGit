package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.squareup.picasso.Picasso;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.zph.glpanorama.GLPanorama;

import java.io.IOException;

/**
 * Created by 72984 on 2018/6/24.
 */

public class OnlineVisitAcivity extends YzsBaseActivity {
   private VrPanoramaView mGLPanorama;
 BudingInfo.ViewDataBean.DataBean bean;
    @Override
    protected void initContentView(Bundle var1) {
     setContentView(R.layout.activity_online_visit);
    }

    @Override
    protected void initView() {
        mGLPanorama= (VrPanoramaView) findViewById(R.id.mVrPanoramaView);
        //传入你的全景图
     VrPanoramaView.Options aNormalOptions = new VrPanoramaView.Options();

     aNormalOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
     // mVrPanoramaView.setFullscreenButtonEnabled (false); //隐藏全屏模式按钮 mVrPanoramaView.setInfoButtonEnabled(false); 
     // 设置隐藏最左边信息的按钮 mVrPanoramaView.setStereoModeButtonEnabled(false); 
     // 设置隐藏立体模型的按钮 mVrPanoramaView.setEventListener(new ActivityEventListener()); //设置监听 //
        getBundleExtras(getIntent().getExtras());
//        Picasso.with(this).load(bean.getRoomMoreImageArr().get(0).getImageUrl()).
//        try {
//            mGLPanorama.loadImageFromBitmap(, aNormalOptions);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) {

     bean = (BudingInfo.ViewDataBean.DataBean) var1.getSerializable("bean");

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
