package com.cloudtenant.yunmenkeji.cloudTenant.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDexApplication;


/**
 * Created by Horrarndoo on 2017/9/1.
 * <p>
 * 全局Application
 */

public class BuoyApplication extends MultiDexApplication {
    private static final String LOG_TAG = "YZ_LOGGER";
    protected static Context context;
    protected static Handler handler;
    protected static int mainThreadId;
    private static BuoyApplication mApp;
    private boolean isLongin=false;


    public static synchronized BuoyApplication getInstance() {
        return mApp;
    }



    public boolean isLogin(){

        return isLongin;

    }

    public boolean isLongin() {
        return isLongin;
    }

    public void setLongin(boolean longin) {
        isLongin = longin;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();
        mApp=this;
    }

    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
