package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 72984 on 2018/6/24.
 */
@EActivity
public class TnementAcitivity extends YzsBaseActivity {

    @Click(R.id.ll_online_visit)
   void onClick(){

//        readyGo(OnlineVisitAcivity.class);
    }
    @Override
    protected void initContentView(Bundle var1) {
       setContentView(R.layout.activity_tnement);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {
        setMainText("组这间？");

    }

    @Override
    protected void getBundleExtras(Bundle var1) {

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
