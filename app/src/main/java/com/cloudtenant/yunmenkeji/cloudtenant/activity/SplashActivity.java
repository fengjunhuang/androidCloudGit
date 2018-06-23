package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by 72984 on 2018/6/17.
 */
@EActivity
public class SplashActivity extends YzsBaseActivity {
    @ViewById(R.id.banner_guide_content)
    BGABanner mBackgroundBanner;
    @ViewById(R.id.banner_guide_fore)
    BGABanner mforeBanner;

    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void initView() {
        setListener();
        processLogic();


    }
    private void processLogic() {
        // Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
        List<View> views = new ArrayList<>();
        views.add(getPageView(R.drawable.uoko_guide_background_1));

        views.add(getPageView(R.drawable.uoko_guide_background_2));
        views.add(getPageView(R.drawable.uoko_guide_background_3));
        List<View> foreViews = new ArrayList<>();
        foreViews.add(getPageView(R.drawable.uoko_guide_foreground_1));
        foreViews.add(getPageView(R.drawable.uoko_guide_foreground_2));
        foreViews.add(getPageView(R.drawable.uoko_guide_foreground_3));
        mBackgroundBanner.setData(views);
        mforeBanner.setData(foreViews);
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
    private View getPageView(@DrawableRes int resid) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resid);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
    private void setListener() {
        /**
         * 设置进入按钮和跳过按钮控件资源 id 及其点击事件
         * 如果进入按钮和跳过按钮有一个不存在的话就传 0
         * 在 BGABanner 里已经帮开发者处理了防止重复点击事件
         * 在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        mforeBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, 0, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                startActivity(new Intent(SplashActivity.this, LoginActivity_.class));
                finish();
            }
        });
    }
}
