package com.cloudtenant.yunmenkeji.cloudtenant.base;

/**
 * Created by feng on 2017/12/13.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.util.RxBarTool;
import com.cloudtenant.yunmenkeji.cloudtenant.util.WaitPorgressDialog;
import com.cloudtenant.yunmenkeji.cloudtenant.view.MLoadingDialog;


import com.gyf.barlibrary.ImmersionBar;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.loading.LoadingDialog;
import com.yzs.yzsbaseactivitylib.util.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;



public abstract class YzsBaseActivity extends me.yokeyword.fragmentation.SupportActivity {
    private static final String TAG = "YzsBaseActivity";
    protected View emptyView;
    public boolean useTitle = true;
    public Toolbar mToolbar;
    public TextView title;
    public ImageView back;
    public TextView tv_menu;
    public MLoadingDialog m_cProgressDialog;
    private View btn1;
    private View btn2;

    public View getBtn1() {
        btn1.setVisibility(View.VISIBLE);
        return btn1;
    }

    public void setBtn1(View btn1) {

        this.btn1 = btn1;
    }

    public View getBtn2() {
        btn2.setVisibility(View.VISIBLE);
        return btn2;
    }

    public void setBtn2(View btn2) {
        this.btn2 = btn2;
    }

    public View getTitleView() {

        return  findViewById(R.id.include_title);
    }

    public void setTitleView(View titleView) {
        this.titleView = titleView;
    }
    public void  setSmellText(String s){
        ((TextView) getTitleView().findViewById(R.id.tv_small)).setVisibility(View.VISIBLE);
        ((TextView) getTitleView().findViewById(R.id.tv_small)).setText(s);
    }
    public void  setMainText(String s){
        ((TextView) getTitleView().findViewById(R.id.tv_main)).setVisibility(View.VISIBLE);
        ((TextView) getTitleView().findViewById(R.id.tv_main)).setText(s);
    }

    public ImageView iv_menu;
    public  View titleView;
    protected WaitPorgressDialog mWaitPorgressDialog;
    public YzsBaseActivity() {

    }

    public Toolbar getmToolbar() {
        return mToolbar;
    }



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


     ImmersionBar.with(this)

                .statusBarColor(R.color.transparent)
                .init();
//        RxBarTool.setNoTitle(this);
//        RxBarTool.setTransparentStatusBar(this);//状态栏透明化
//        RxBarTool.StatusBarLightMode(this);
        Bundle extras = this.getIntent().getExtras();

        if(null != extras) {
            ;
        }

        EventBus.getDefault().register(this);
        this.initContentView(savedInstanceState);
        this.titleView = findViewById(R.id.include_title);
        if(null != this.titleView) {
//            this.setSupportActionBar(this.mToolbar);
//            this.getSupportActionBar().setDisplayShowTitleEnabled(false);
            this.initTitle();

        }

        this.initView();
        this.initLogic();
/*        AndroidBug5497Workaround.assistActivity(this);*/

    }

    protected abstract void initContentView(Bundle var1);

    protected abstract void initView();

    protected abstract void initLogic();

    protected abstract void getBundleExtras(Bundle var1);

    protected void initTitle() {
       this.titleView.findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();

           }
       });
      btn1=  this.titleView.findViewById(R.id.btn_op1);
        btn2=  this.titleView.findViewById(R.id.btn_op2);
    }
    public void setBtn1Vis(){


    }

    public void setTitle(String string) {
        if(null != this.title) {
            this.title.setText(string);
        }

    }
    public void setRightText(String string) {
        if(null != this.title) {
            tv_menu.setText(string);
        }

    }
    public void setTitle(int id) {
        if(null != this.title) {
            this.title.setText(id);
        }

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = this.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        int bits = 67108864;
        if(on) {
            winParams.flags |= 67108864;
        } else {
            winParams.flags &= -67108865;
        }

        win.setAttributes(winParams);
    }

    public static void setTransparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);  //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); //透明导航栏
        }
    }

    @Subscribe
    public void onEventMainThread(EventCenter center) {
        if(null != center) {
            this.onEventComing(center);
        }

    }

    protected abstract void onEventComing(EventCenter var1);

    protected void showLoadingDialog() {
        if (isFinishing()) {
            return;
        }
        if (m_cProgressDialog == null) {
            m_cProgressDialog = new MLoadingDialog(this);
        }

    }

    protected void showLoadingDialog(int type) {

        LoadingDialog.showLoadingDialog(this, type);
    }

    protected void showLoadingDialog(int type, int drawableId) {
        LoadingDialog.showLoadingDialog(this, type, drawableId);
    }

    protected void showLoadingDialog(String str) {
        LoadingDialog.showLoadingDialog(this, str);
    }

    protected void showLoadingDialog(int type, String str) {
        LoadingDialog.showLoadingDialog(this, type, str);
    }

    protected void showLoadingDialog(int type, String str, int drawable) {
        LoadingDialog.showLoadingDialog(this, type, str, drawable);
    }

    protected void cancelLoadingDialog() {
        if (m_cProgressDialog != null) {
            m_cProgressDialog.dismiss();
        }
    }

    protected void showShortToast(String string) {
        ToastUtils.showShortToast(this, string);
    }

    protected void showShortToast(int stringId) {
        ToastUtils.showShortToast(this, stringId);
    }

    protected void showLongToast(String string) {
        ToastUtils.showShortToast(this, string);
    }

    protected void showLongToast(int stringId) {
        ToastUtils.showShortToast(this, stringId);
    }

    protected void onDestroy() {
        this.emptyView = null;
        EventBus.getDefault().unregister(this);
        ImmersionBar.with(this).destroy();
        super.onDestroy();

    }

    protected void readyGo(Class<?> clazz) {
        this.readyGo(clazz, (Bundle)null);
    }

    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if(null != bundle) {
            intent.putExtras(bundle);
        }

        this.startActivity(intent);
    }

    protected void readyGoThenKill(Class<?> clazz) {
        this.readyGoThenKill(clazz, (Bundle)null);
    }

    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        this.readyGo(clazz, bundle);
        this.finish();
    }

    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        this.startActivityForResult(intent, requestCode);
    }

    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if(null != bundle) {
            intent.putExtras(bundle);
        }

        this.startActivityForResult(intent, requestCode);
    }


}
