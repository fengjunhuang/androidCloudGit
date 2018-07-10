package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

import android.util.Log;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;


import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;

import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

/**
 * Created by 72984 on 2018/6/24.
 */

public class RoutingActivity extends YzsBaseActivity  implements TencentLocationListener {
    private TencentLocationManager locationManager;
    private TencentLocationRequest locationRequest;
    private Marker myLocation;
    private Circle accuracy;
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_routing);
    }
    MapView mapview=null;
    TencentMap tencentMap;

    @Override
    protected void initView() {

        mapview=(MapView)findViewById(R.id.map);
//获取TencentMap实例
       tencentMap = mapview.getMap();

//设置实时路况开启
        tencentMap.setTrafficEnabled(true);
    init();


    }
    protected void bindListener() {

        // TODO Auto-generated method stub
        int error = locationManager.requestLocationUpdates(
                locationRequest,RoutingActivity.this);
        switch (error) {
            case 0:
                Log.e("location", "成功注册监听器");
                break;
            case 1:
                Log.e("location", "设备缺少使用腾讯定位服务需要的基本条件");
                break;
            case 2:
                Log.e("location", "manifest 中配置的 key 不正确");
                break;
            case 3:
                Log.e("location", "自动加载libtencentloc.so失败");
                break;

            default:
                break;
        }


    }


    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    protected void init() {

        locationManager = TencentLocationManager.getInstance(this);
        locationRequest = TencentLocationRequest.create();
        bindListener();



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


    @Override
    public void onLocationChanged(TencentLocation tencentLocation, int i, String s) {
        if (TencentLocation.ERROR_OK == i) {
            System.out.print("");
            // 定位成功
        } else {
            // 定位失败
            System.out.print("");
        }
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
