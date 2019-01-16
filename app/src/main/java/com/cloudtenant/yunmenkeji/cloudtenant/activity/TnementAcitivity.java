package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo1;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo3;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMoreImageArrBean;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.TnementBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.squareup.picasso.Picasso;
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
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 72984 on 2018/6/24.
 */
@EActivity
public class TnementAcitivity extends YzsBaseActivity implements TencentLocationListener {
    @ViewById(R.id.map)
    MapView mapview;
    @ViewById(R.id.iv_cell_image)
    ImageView iv_cell;
    @ViewById(R.id.is_sc)
    ImageView is_sc;
    @ViewById(R.id.tv_cell_remain)
    TextView tv_cell_remain;
    @ViewById(R.id.tv_seeTimes)
    TextView tv_seeTimes;
    @ViewById(R.id.tv_cell_cost)
    TextView tv_cell_cost;
    @ViewById(R.id.tv_kongtiao)
    TextView tv_kongtiao;
    @ViewById(R.id.tv_chuang)
    TextView tv_chuang;
    @ViewById(R.id.tv_reshuiqi)
    TextView tv_reshuiqi;
    @ViewById(R.id.tv_xiyiji)
    TextView tv_xiyiji;
    @ViewById(R.id.tv_dianshiji)
    TextView tv_dianshiji;
    @ViewById(R.id.tv_yigui)
    TextView tv_yigui;
    @ViewById(R.id.tv_shafa)
    TextView tv_shafa;
    @ViewById(R.id.tv_huangdai)
    TextView tv_huangdai;
    @ViewById(R.id.tv_tianranqi)
    TextView tv_tianranqi;
    @ViewById(R.id.tv_bingxiang)
    TextView tv_bingxiang;
    @ViewById(R.id.tv_style)
    TextView tv_style;
    @Click(R.id.iv_cell_image)


   void onClick(){
      Bundle bundle =new Bundle();
      bundle.putSerializable("bean",tnementBean);
       readyGo(OnlineVisitAcivity.class,bundle);
    }
    private  HouseDetil.ViewDataBean houseDetil;
    int start=0;
    int end=4;
    Context mContext=this;
    private List<TextView> ss =new ArrayList<>();
    BudingInfo.ViewDataBean.DataBean bean ;
    TnementBean tnementBean=new TnementBean();
    @Override
    protected void initContentView(Bundle var1) {
       setContentView(R.layout.activity_tnement);
        roomInfo();
    }

    @Override
    protected void initView() {
        findViewById(R.id.ll_details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                bundle.putSerializable("bean",tnementBean);
                bundle.putSerializable("houseDetil",houseDetil);
                readyGo(ContractDetailsActivity.class,bundle);
            }
        });
    }

    @Override
    protected void initLogic() {
        ss.add(tv_bingxiang);
        ss.add(tv_dianshiji);
        ss.add(tv_chuang);
        ss.add(tv_kongtiao);
        ss.add(tv_huangdai);
        ss.add(tv_reshuiqi);
        ss.add(tv_xiyiji);
        ss.add(tv_tianranqi);
        ss.add(tv_dianshiji);
        try {
            getBundleExtras(getIntent().getExtras());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getBtn1().setVisibility(View.INVISIBLE);
        getBtn2().setVisibility(View.INVISIBLE);
        getTv_out().setVisibility(View.VISIBLE);

        hideLine();
    }
    protected void bindListener() {

        // TODO Auto-generated method stub
        int error = locationManager.requestLocationUpdates(
                locationRequest,this);
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
        tencentMap.setOnMarkerClickListener(new TencentMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                // TODO Auto-generated method stub
               /* Bundle bundle =new Bundle();
                bundle.putSerializable("bean",(HouseDetil.ViewDataBean)arg0.getTag());
                readyGo(HouseDetilActivity.class,bundle);*/
                Intent intent=new Intent(mContext,RoutingActivity.class);
                try {
                    intent.putExtra("lat",bean1.getViewData().get(0).getRoomLat());
                    intent.putExtra("longitude",bean1.getViewData().get(0).getRoomLng());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startActivity(intent);
                return false;
            }
        });

    }
    TencentMap tencentMap;
    private TencentLocationManager locationManager;
    private TencentLocationRequest locationRequest;
    private  List<Marker> markers =new ArrayList<>();
    private  String roomId;
    private boolean isSC=false;
    @Override
    protected void getBundleExtras(Bundle var1) throws Exception {


        if (var1.getBoolean("isMap")) {
            roomId=var1.getString("roomId");
            roomInfo();
            mapview.setVisibility(View.VISIBLE);
            tencentMap = mapview.getMap();
            //设置实时路况开启
            tencentMap.setTrafficEnabled(true);
            tencentMap.setZoom(13);
            locationManager = TencentLocationManager.getInstance(this);
            locationRequest = TencentLocationRequest.create();

            bindListener();

        }else {
            bean = (BudingInfo.ViewDataBean.DataBean) var1.getSerializable("bean");
            houseDetil= (HouseDetil.ViewDataBean) var1.getSerializable("houseDetil");
            tnementBean.setCellName(houseDetil.getCellName());
            tnementBean.setRoomSimpleImage(bean.getRoomSimpleImage());
            tnementBean.setRoomNumber(bean.getRoomNumber());
            tnementBean.setRoomSquare(bean.getRoomSquare());
            tnementBean.setRoomMoney(bean.getRoomMoney());
            tnementBean.setRoomSet(bean.getRoomSet());
            tnementBean.setContract(var1.getString("contract"));
            List<RoomMoreImageArrBean> list=new ArrayList<>();
            for (int i = 0; i < bean.getRoomMoreImageArr().size(); i++) {
                list.add(new RoomMoreImageArrBean(bean.getRoomMoreImageArr().get(i).getImageTitle(),
                        bean.getRoomMoreImageArr().get(i).getImageInfo(),
                        bean.getRoomMoreImageArr().get(i).getImageFullView(),
                        HttpMethods.BASE_URL+bean.getRoomMoreImageArr().get(i).getImageUrl()));
            }
            tnementBean.setRoomMoreImageArr(list);


            getTv_smell().setVisibility(View.GONE);
            setMainText(houseDetil.getCellName());
            Picasso.with(this).load(HttpMethods.BASE_URL+bean.getRoomSimpleImage()).fit().into(iv_cell);
            tv_cell_remain.setText(bean.getRoomNumber());
            SpannableString msp = new SpannableString("￥" + bean.getRoomMoney() + "/月");
            int size=bean.getRoomMoney().length()+1;
            msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
            //给限定字符之间的字符着色
            msp.setSpan(new ForegroundColorSpan(Color.BLACK), start, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            //设置字体大小  单位：dp
            //msp.setSpan(new AbsoluteSizeSpan(11, true), size, end+3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_cell_cost.setText(msp);
            tv_style.setText(bean.getRoomStyle());
            tv_seeTimes.setText(bean.getRoomReadNum());
            Log.d("TnementAcitivity","isCollection="+bean.getIsCollection());
            if (bean.getIsCollection().equals("false")) {
                is_sc.setImageResource(R.drawable.sc);
                isSC=false;
            }else {
                is_sc.setImageResource(R.drawable.shoucang);
                isSC=true;
            }
            is_sc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isSC) {
                        is_sc.setImageResource(R.drawable.sc);
                        isSC=!isSC;
                    }else {
                        is_sc.setImageResource(R.drawable.shoucang);
                        isSC=!isSC;
                    }
                }
            });
            getTv_smell().setTextColor(Color.BLACK);
            String l="";
            switch (bean.getRoomMarginType()){
                case 0:{
                    l="一按一租";
                }break;case 1:{
                    l="两按一租";
                }break;case 2:{
                    l="三按一租";
                }break;
                default:break;
            }
            String r="";
            switch (bean.getRoomStyle()){
                case "0":{
                    r="单间";
                }break;case "1":{
                    r="一房一厅";
                }break;case "2":{
                    r="二房一厅";
                }break;case "3":{
                    r="三房一厅";
                }break;case "4":{
                    r="复试";
                }break;case "5":{
                    r="未知";
                }break;
                default:break;
            }
            tv_style.setText(l+" | "+r);

            if (bean.getRoomSet().contains("床")) {
                tv_chuang.setBackgroundResource(R.drawable.image_bed);
            }
            if (bean.getRoomSet().contains("热水器")) {
                tv_reshuiqi.setBackgroundResource(R.drawable.image_heater);
            }
            if (bean.getRoomSet().contains("空调")) {
                tv_kongtiao.setBackgroundResource(R.drawable.image_aircondition);
            }
            if (bean.getRoomSet().contains("宽带")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_web);
            }if (bean.getRoomSet().contains("洗衣机")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_washer);
            }if (bean.getRoomSet().contains("沙发")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_sofa);
            }if (bean.getRoomSet().contains("电视")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_televition);
            }if (bean.getRoomSet().contains("冰箱")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_fridge);
            }if (bean.getRoomSet().contains("天然气")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_gas);
            }if (bean.getRoomSet().contains("衣柜")) {
                tv_huangdai.setBackgroundResource(R.drawable.image_closet);
            }
        }

     }


    RoomInfo3 bean1;
    private void roomInfo() {
        HttpMethods.getInstance().roomInfo1(new BaseObserver<RoomInfo3>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                bean1= (RoomInfo3) t;

                Log.d("TnementAcitivity",bean1.getHetong());
                Log.d("TnementAcitivity",""+bean1.getViewData().get(0).getRoomSet());
//                init();
            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"gvy7vXSB",UserLocalData.getUser(this).getUserPhone());
    }

//    private void init() throws Exception {
//        List<RoomMoreImageArrBean> list=new ArrayList<>();
//        for (int i = 0; i < bean1.getViewData().get(0).getRoomMoreImageArr().size(); i++) {
//            list.add(new RoomMoreImageArrBean(bean1.getViewData().get(0).getRoomMoreImageArr().get(i).getImageTitle(),
//                    bean1.getViewData().get(0).getRoomMoreImageArr().get(i).getImageInfo(),
//                    bean1.getViewData().get(0).getRoomMoreImageArr().get(i).getImageFullView()+"",
//                    HttpMethods.BASE_URL+bean1.getViewData().get(0).getRoomMoreImageArr().get(i).getImageUrl()));
//        }
//        tnementBean.setRoomMoreImageArr(list);
//        tnementBean.setRoomMoney(bean1.getViewData().get(0).getRoomMoney()+"");
//        tnementBean.setRoomNumber(bean1.getViewData().get(0).getRoomNumber()+"");
//        tnementBean.setRoomSquare(bean1.getViewData().get(0).getRoomSquare());
//        tnementBean.setContract(bean1.getContract());
//
//        Picasso.with(this).load(HttpMethods.BASE_URL+bean1.getViewData().get(0).getRoomSimpleImage()).fit().into(iv_cell);
//        tv_cell_remain.setText(bean1.getViewData().get(0).getRoomNumber());
//        SpannableString msp = new SpannableString("￥" + bean1.getViewData().get(0).getRoomMoney() + "/月");
//        String aa=bean1.getViewData().get(0).getRoomMoney()+"";
//        int size=aa.length()+1;
//        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
//        //给限定字符之间的字符着色
//        msp.setSpan(new ForegroundColorSpan(Color.BLACK), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //设置字体大小  单位：dp
//        msp.setSpan(new AbsoluteSizeSpan(11, true), end+1, end+3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tv_cell_cost.setText(msp);
//
//        tv_seeTimes.setText(bean.getRoomReadNum());
//        Log.d("TnementAcitivity","isCollection="+bean.getIsCollection());
//        if (bean.getIsCollection().equals("false")) {
//            is_sc.setImageResource(R.drawable.sc);
//            isSC=false;
//        }else {
//            is_sc.setImageResource(R.drawable.shoucang);
//            isSC=true;
//        }
//        is_sc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (isSC) {
//                    is_sc.setImageResource(R.drawable.sc);
//                    isSC=!isSC;
//                }else {
//                    is_sc.setImageResource(R.drawable.shoucang);
//                    isSC=!isSC;
//                }
//            }
//        });
//        String l="";
//        switch (bean1.getViewData().get(0).getRoomMarginType()){
//            case "0":{
//                l="一按一租";
//            }break;case "1":{
//                l="两按一租";
//            }break;case "2":{
//                l="三按一租";
//            }break;
//            default:break;
//        }
//        String r="";
//        switch (bean1.getViewData().get(0).getRoomStyle()){
//            case "0":{
//                r="单间";
//            }break;case "1":{
//                r="一房一厅";
//            }break;case "2":{
//                r="二房一厅";
//            }break;case "3":{
//                r="三房一厅";
//            }break;case "4":{
//                r="复试";
//            }break;case "5":{
//                r="未知";
//            }break;
//            default:break;
//        }
//        tv_style.setText(l+" | "+r);
//        getTv_smell().setTextColor(Color.BLACK);
//
//        if (bean1.getViewData().get(0).getRoomSet().contains("床")) {
//            tv_chuang.setBackgroundResource(R.drawable.image_bed);
//        }
//        if (bean1.getViewData().get(0).getRoomSet().contains("热水器")) {
//            tv_reshuiqi.setBackgroundResource(R.drawable.image_heater);
//        }
//        if (bean1.getViewData().get(0).getRoomSet().contains("空调")) {
//            tv_kongtiao.setBackgroundResource(R.drawable.image_aircondition);
//        }
//        if (bean1.getViewData().get(0).getRoomSet().contains("宽带")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_web);
//        }if (bean1.getViewData().get(0).getRoomSet().contains("洗衣机")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_washer);
//        }if (bean1.getViewData().get(0).getRoomSet().contains("沙发")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_sofa);
//        }if (bean1.getViewData().get(0).getRoomSet().contains("电视")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_televition);
//        }if (bean1.getViewData().get(0).getRoomSet().contains("冰箱")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_fridge);
//        }if (bean1.getViewData().get(0).getRoomSet().contains("天然气")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_gas);
//        }if (bean1.getViewData().get(0).getRoomSet().contains("衣柜")) {
//            tv_huangdai.setBackgroundResource(R.drawable.image_closet);
//        }
//        initMyMap();
//    }

    private void initMyMap() throws Exception {
        //List<HouseDetil.ViewDataBean>  list= viewDataBean;
        RoomInfo3.ViewDataBean viewDataBean=bean1.getViewData().get(0);
        Log.d("initMyMap","初始化map");
        tencentMap.setInfoWindowAdapter(new TencentMap.InfoWindowAdapter() {
            //infoWindow关闭后调用，用户回收View
            @Override
            public void onInfoWindowDettached(Marker arg0, View arg1) {
                // TODO Auto-generated method stub
            }
            //infoWindow弹出前调用，返回的view将作为弹出的infoWindow
            @Override
            public View getInfoWindow(Marker arg0) {
                // TODO Auto-generated method stub
                View view=     LayoutInflater.from(mContext).inflate(R.layout.item_map_info,null);
                ImageView iv_pic= view.findViewById(R.id.iv_pic);
                TextView tv_shengxia= view.findViewById(R.id.tv_shengxia);

                TextView tv_name= view.findViewById(R.id.tv_name);
                TextView tv_pay= view.findViewById(R.id.tv_pay);
                TextView tv_desc= view.findViewById(R.id.tv_desc);
                //HouseDetil.ViewDataBean bean = (HouseDetil.ViewDataBean) arg0.getTag();
                /*tv_name.setText(bean1.getCellName());
                tv_pay.setText(bean1.getCellCost());

                Picasso.with(mContext).load(bean1.getCellImage()).fit().into(iv_pic);
                tv_shengxia.setText("剩:"+viewDataBean.get+"间");*/
                return null;
            }
        });

        LatLng latLng = new LatLng(Double.valueOf(viewDataBean.getRoomLat()),Double.valueOf(viewDataBean.getRoomLng()));
        final Marker marker = tencentMap.addMarker(new MarkerOptions().
                position(latLng).
                title("点击查看路线"));

        marker.setTag(bean);
        marker.showInfoWindow();// 设置默认显示一个infoWindow

        markers.add(marker);

    }
    private  boolean isFist =true;
    private Marker myLocation;
    private Circle accuracy;
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
            if(isFist){
                tencentMap.setCenter(latLng);
                isFist=false;
            }

            if (accuracy == null) {
                accuracy = tencentMap.addCircle(new CircleOptions().
                        center(latLng).
                        radius((double)arg0.getAccuracy()).
                        fillColor(0x440000ff).
                        strokeWidth(0f));
            }
            myLocation.setPosition(latLng);
            myLocation.setRotation(arg0.getBearing()); //仅当定位来源于gps有效，或者使用方向传感器
            accuracy.setCenter(latLng);
            accuracy.setRadius(arg0.getAccuracy());

        } else {

        }
    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }
    @Override
    public void onStop() {
        super.onStop();
        mapview.onStop();
    }
    @Override
    public void onPause() {
        super.onPause();
        mapview.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapview!=null) {
            mapview.onResume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapview.onDestroy();
    }
    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
