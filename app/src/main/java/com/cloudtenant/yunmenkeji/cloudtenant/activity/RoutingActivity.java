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
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

/**
 * Created by 72984 on 2018/6/24.
 */

public class RoutingActivity extends YzsBaseActivity  implements TencentLocationListener {
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_routing);
    }
    MapView mapview=null;
    TencentMap tencentMap;
    private DemoLocationSource locationSource;
    @Override
    protected void initView() {

        mapview=(MapView)findViewById(R.id.map);
//获取TencentMap实例
       tencentMap = mapview.getMap();

//设置实时路况开启
        tencentMap.setTrafficEnabled(true);
    init();


    }

    protected void init() {



        tencentMap.getUiSettings().setZoomControlsEnabled(false);

        locationSource = new DemoLocationSource(this);
        tencentMap.setLocationSource(locationSource);
        tencentMap.setMyLocationEnabled(true);
        locationSource.onResume();
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


    class DemoLocationSource implements LocationSource, TencentLocationListener {

        private Context mContext;
        private OnLocationChangedListener mChangedListener;
        private TencentLocationManager locationManager;
        private TencentLocationRequest locationRequest;

        public DemoLocationSource(Context context) {
            // TODO Auto-generated constructor stub
            mContext = context;
            locationManager = TencentLocationManager.getInstance(mContext);
            locationRequest = TencentLocationRequest.create();
            locationRequest.setInterval(2000);
        }

        @Override
        public void onLocationChanged(TencentLocation arg0, int arg1,
                                      String arg2) {
            // TODO Auto-generated method stub
            if (arg1 == TencentLocation.ERROR_OK && mChangedListener != null) {
                Log.e("maplocation", "location: " + arg0.getCity() + " " + arg0.getProvider());
                Location location = new Location(arg0.getProvider());
                location.setLatitude(arg0.getLatitude());
                location.setLongitude(arg0.getLongitude());
                location.setAccuracy(arg0.getAccuracy());
                mChangedListener.onLocationChanged(location);
            }
        }

        @Override
        public void onStatusUpdate(String arg0, int arg1, String arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void activate(OnLocationChangedListener arg0) {
            // TODO Auto-generated method stub
            mChangedListener = arg0;
            int err = locationManager.requestLocationUpdates(locationRequest, this);
            switch (err) {
                case 1:
                    System.out.println("设备缺少使用腾讯定位服务需要的基本条件");

                    break;
                case 2:
                    System.out.println("manifest 中配置的 key 不正确");

                    break;
                case 3:
                    System.out.println("自动加载libtencentloc.so失败");

                    break;

                default:
                    break;
            }
        }

        @Override
        public void deactivate() {
            // TODO Auto-generated method stub
            locationManager.removeUpdates(this);
            mContext = null;
            locationManager = null;
            locationRequest = null;
            mChangedListener = null;
        }

        public void onPause() {
            locationManager.removeUpdates(this);
        }

        public void onResume() {
            locationManager.requestLocationUpdates(locationRequest, this);
        }

    }
}
