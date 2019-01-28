package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;


import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.param.DrivingParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.TransitParam;
import com.tencent.lbssearch.object.param.WalkingParam;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;

import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 72984 on 2018/6/24.
 */

public class RoutingActivity extends YzsBaseActivity  implements TencentLocationListener ,View.OnClickListener{
    private TencentLocationManager locationManager;
    private TencentLocationRequest locationRequest;
    private Marker myLocation;
    private Circle accuracy;
    HouseDetil.ViewDataBean bean;
    private String lat,longitude,startLat,startLongitude;
    HttpResponseListener directionResponseListener =
            new HttpResponseListener() {

                @Override
                public void onSuccess(int arg0, BaseObject arg1) {
                    // TODO Auto-generated method stub
                    if (arg1 == null) {
                        return;
                    }
                    Log.e("searchdemo", "plan success");
                    tencentMap.clearAllOverlays();
                    RoutePlanningObject obj = (RoutePlanningObject)arg1;
                    if (obj instanceof WalkingResultObject) {
                        WalkingResultObject walkObj = (WalkingResultObject) obj;
                        List<WalkingResultObject.Route> walkRoutes = walkObj.result.routes;
                        drawSolidLine(walkRoutes.get(0).polyline);

                        Log.e("searchdemo", "plan>direction="+walkRoutes.get(0).direction);
                        Log.e("searchdemo", "plan>mode="+walkRoutes.get(0).mode);
                        Log.e("searchdemo", "plan》=distance"+walkRoutes.get(0).distance);
                        Log.e("searchdemo", "plan》=duration"+walkRoutes.get(0).duration);
                    } else if (obj instanceof DrivingResultObject) {
                        DrivingResultObject drivingObj = (DrivingResultObject) obj;
                        List<DrivingResultObject.Route> driveRoutes = drivingObj.result.routes;
                        drawSolidLine(driveRoutes.get(0).polyline);
                    } else if (obj instanceof TransitResultObject) {
                        TransitResultObject transitObj = (TransitResultObject) obj;
                        List<TransitResultObject.Route> transitRoutes = transitObj.result.routes;
                        List<TransitResultObject.Segment> segments =
                                transitRoutes.get(0).steps;
                        for (TransitResultObject.Segment segment : segments) {
                            if (segment instanceof TransitResultObject.Walking) {
                                drawDotLine(((TransitResultObject.Walking) segment).polyline);
                            } if (segment instanceof TransitResultObject.Transit) {
                                drawSolidLine(((TransitResultObject.Transit) segment).lines.get(0).polyline);
                            }
                        }
                    }
                }

                @Override
                public void onFailure(int arg0, String arg1, Throwable arg2) {
                    // TODO Auto-generated method stub
                    Log.e("searchdemo", "plan 失败>>"+arg1);
                    Toast.makeText(RoutingActivity.this, "未找到该路线！！"+arg1, Toast.LENGTH_SHORT).show();
                }
            };
    @Override
    protected void initContentView(Bundle var1) {
        Intent intent=getIntent();
        lat=intent.getStringExtra("lat");
        longitude=intent.getStringExtra("longitude");
        Log.e("location", "lat="+lat+">>>>>longitude="+longitude);

        setContentView(R.layout.activity_routing);
    }
    MapView mapview=null;
    TencentMap tencentMap;
    TextView btnTransit,btndrive,btnWalk;
    int state;
    @Override
    public void onClick(View view) {
        if (view.getId()!=state){
                btnTransit.setBackgroundColor(Color.WHITE);
                btndrive.setBackgroundColor(Color.WHITE);
                btnWalk.setBackgroundColor(Color.WHITE);
                btnTransit.setTextColor(Color.BLACK);
                btndrive.setTextColor(Color.BLACK);
                btnWalk.setTextColor(Color.BLACK);
                switch (view.getId()){

                    case R.id.iv_walk:{
                        clickWalk(view.getId());
                    }break;
                    case R.id.iv_drive:{
                        clickDrive(view.getId());
                    }break;
                    case R.id.iv_transit:{
                        clickTransit(view.getId());
                    }break;
                    default:
                        break;
                }
        }

    }

    private void clickTransit(int i) {
        btnTransit.setTextColor(Color.WHITE);
        btnTransit.setBackgroundColor(getResources().getColor(R.color.gren_cut_clorr));
        getTransitPlan();
        state=i;
    }

    private void clickDrive(int i) {
        btndrive.setTextColor(Color.WHITE);
        btndrive.setBackgroundColor(getResources().getColor(R.color.gren_cut_clorr));
        getDrivePlan();
        state=i;
    }

    private void clickWalk(int i) {
        btnWalk.setTextColor(Color.WHITE);
        btnWalk.setBackgroundColor(getResources().getColor(R.color.gren_cut_clorr));
        getWalkPlan();
        state=i;
    }
    /**
     * 将路线以虚线画到地图上，用于公交中的步行
     * @param locations
     */
    protected void drawDotLine(List<com.tencent.lbssearch.object.Location> locations) {
        tencentMap.addPolyline(new PolylineOptions().
                addAll(getLatLngs(locations)).
                color(0xff2200ff).
                setDottedLine(true));
    }

    /**
     * 将路线以实线画到地图上
     * @param locations
     */
    protected void drawSolidLine(List<com.tencent.lbssearch.object.Location> locations) {
        tencentMap.addPolyline(new PolylineOptions().
                addAll(getLatLngs(locations)).
                color(0xff2200ff));
    }
    protected List<LatLng> getLatLngs(List<com.tencent.lbssearch.object.Location> locations) {
        List<LatLng> latLngs = new ArrayList<LatLng>();
        for (com.tencent.lbssearch.object.Location location : locations) {
            latLngs.add(new LatLng(location.lat, location.lng));
        }
        return latLngs;
    }
    /**
     * 步行规划，只能设置起点和终点
     */
    protected void getWalkPlan() {
        TencentSearch tencentSearch = new TencentSearch(this);
        WalkingParam walkingParam = new WalkingParam();
        walkingParam.from(new com.tencent.lbssearch.object.Location(Float.parseFloat(startLat),Float.parseFloat(startLongitude)));
        walkingParam.to(new com.tencent.lbssearch.object.Location(Float.parseFloat(lat),Float.parseFloat(longitude)));
        tencentSearch.getDirection(walkingParam, directionResponseListener);
    }
    /**
     * 驾车规划，支持途经点和策略设置，具体信息见文档
     */
    protected void getDrivePlan() {
        TencentSearch tencentSearch = new TencentSearch(this);
        DrivingParam drivingParam = new DrivingParam();

        Log.e("searchdemo", "getDrivePlan> startLat="+startLat);
        Log.e("searchdemo", "getDrivePlan> startLongitude="+startLongitude);
        Log.e("searchdemo", "getDrivePlan> lat="+lat);
        Log.e("searchdemo", "getDrivePlan> longitude="+longitude);
        drivingParam.from(new com.tencent.lbssearch.object.Location(Float.parseFloat(startLat),Float.parseFloat(startLongitude)));
        drivingParam.to(new com.tencent.lbssearch.object.Location(Float.parseFloat(lat),Float.parseFloat(longitude)));
        //策略
        drivingParam.policy(RoutePlanningParam.DrivingPolicy.LEAST_DISTANCE);
        //途经点
        Log.e("searchdemo", "getDrivePlan> 设置查询监听");
//		drivingParam.addWayPoint(new Location(39.898938f, 116.348648f));

        tencentSearch.getDirection(drivingParam, directionResponseListener);
    }

    /**
     * 公交换乘，支持策略，具体信息见文档
     */
    protected void getTransitPlan() {
        TencentSearch tencentSearch = new TencentSearch(this);
        TransitParam transitParam = new TransitParam();
        transitParam.from(new com.tencent.lbssearch.object.Location(Float.parseFloat(startLat),Float.parseFloat(startLongitude)));
        transitParam.to(new com.tencent.lbssearch.object.Location(Float.parseFloat(lat),Float.parseFloat(longitude)));
        //策略
        transitParam.policy(RoutePlanningParam.TransitPolicy.LEAST_TIME);
        tencentSearch.getDirection(transitParam, directionResponseListener);
    }
    @Override
    protected void initView() {
        btnWalk =  findViewById(R.id.iv_walk);
        btndrive = findViewById(R.id.iv_drive);
        btnTransit =  findViewById(R.id.iv_transit);

        mapview=findViewById(R.id.map);
//获取TencentMap实例
       tencentMap = mapview.getMap();

//设置实时路况开启
        tencentMap.setTrafficEnabled(true);
        init();


    }
    boolean isFirst=true;

    protected void bindListener() {
        btnWalk.setOnClickListener(this);
        btndrive.setOnClickListener(this);
        btnTransit.setOnClickListener(this);


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

    private void firstP() {
        if (isFirst) {
            clickDrive(R.id.iv_drive);
            isFirst=false;
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
    protected void getBundleExtras(Bundle bundle) {
        bean = (HouseDetil.ViewDataBean) bundle.getSerializable("bean");
        //lat=bean.getCellLatitude();
        //longitude=bean.getCellLongitude();
        lat=bean.getCellLongitude();
        longitude=bean.getCellLatitude();

        Log.e("location", "lat="+lat+">>>>>longitude="+longitude);

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }


    @Override
    public void onLocationChanged(TencentLocation arg0, int arg1, String s) {

        if (arg1 == TencentLocation.ERROR_OK) {
            LatLng latLng = new LatLng(arg0.getLatitude(), arg0.getLongitude());
            if (myLocation == null) {
                myLocation = tencentMap.addMarker(new MarkerOptions().
                        position(latLng).
                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.navigation)).

                        anchor(0.5f, 0.5f));
            }

            tencentMap.setCenter(latLng);
            startLat=latLng.getLatitude()+"";
            startLongitude=latLng.getLongitude()+"";
            firstP();
            if (accuracy == null) {
                accuracy = tencentMap.addCircle(new CircleOptions().
                        center(latLng).
                        radius((double) arg0.getAccuracy()).
                        fillColor(0x440000ff).
                        strokeWidth(0f));
            }
            myLocation.setPosition(latLng);
            myLocation.setRotation(arg0.getBearing()); //仅当定位来源于gps有效，或者使用方向传感器
            accuracy.setCenter(latLng);
            accuracy.setRadius(arg0.getAccuracy());

        }
    }


    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
