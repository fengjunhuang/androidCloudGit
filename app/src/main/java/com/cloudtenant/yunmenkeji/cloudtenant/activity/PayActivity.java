package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.view.View;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

/**
 * Created by 72984 on 2018/7/30.
 */

public class PayActivity extends YzsBaseActivity {
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_pay);
    }

    @Override
    protected void initView() {
        findViewById(R.id.out).setVisibility(View.VISIBLE);
        setMainText("收款台");
        getBtn1().setVisibility(View.INVISIBLE);
        getBtn2().setVisibility(View.INVISIBLE);
        getTv_smell().setVisibility(View.GONE);
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
