package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MpChartActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.PayActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.SensorActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.PowWindowAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo1;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BillHistoryModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ImageText;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.model.NewBaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.NewBaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.view.CommonPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.LoadingLayout;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.Solve7PopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.TriangleDrawable;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yuyh.library.BubblePopupWindow;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import com.yzs.yzslibrary.util.SizeUtils;
import com.zyyoona7.popup.EasyPopup;
import com.zyyoona7.popup.XGravity;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BillHistoryModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.zyyoona7.popup.YGravity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;


public class RoomFragment extends YzsBaseListFragment<SensorModel.ViewDataBean> implements CommonPopupWindow.ViewInterface,View.OnClickListener{

    LineChart mLineChart;
    View myScrollView;
    private BillHistoryModel billListModel;
    private ImageView iv_select;
    private  CommonPopupWindow popupWindow;
    private LoadingLayout mLoading;
    private PopupWindow      mPopWindow;
    RecyclerView recyclerView;
    PowWindowAdapter powWindowAdapter;
    ArrayList<Entry> entries=new ArrayList<>();
    ArrayList<Entry> entries1=new ArrayList<>();
    private  TextView tv_fangzu;
    private  TextView tv_shuifei;
    private  TextView tv_dianfei;
    private  TextView tv_qita;
    private  TextView tv_result;
    private  TextView  tv_title;
    private  LinearLayout ll_yijian;
    private  View view1;
    private  int index;
    private  RoomModel roomModel;
    private  View containview;
    private List<Map<String, Object>> riskAreaList = null;

    @Override
    protected void initItemLayout() {
        setLayoutResId(R.layout.item_safe_sensor);
        setListType(LINEAR_LAYOUT_MANAGER, false);

    }
    /*@Override
    protected void MyHolder(final BaseViewHolder baseViewHolder, final SensorModel.ViewDataBean myRoomSensorListBean) {




        if (billListModel.getViewData().size() > 0) {
            ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
            ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
            baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
            ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:欠费停用");

        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_name))).setText(myRoomSensorListBean.getGateModel());
        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setText("所在位置:"+myRoomSensorListBean.getPosition());
        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_tem))).setText("温度:"+myRoomSensorListBean.getTen()+"℃");
        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_light))).setText("光线强度:"+myRoomSensorListBean.getLight());
        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_wet))).setText("湿度:"+myRoomSensorListBean.getSecurityStatus()+"%");

        if (billListModel.getViewData().size()>0)
        {
            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
            baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:欠费停用");
            baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("onClick", "给钱");

                }
            });

        } else {
            baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("onClick", "给钱");
                }
            });
        }

            if (myRoomSensorListBean.getSecurityStatus().equals("1")) {
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setTextColor(Color.WHITE);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
                baseViewHolder.convertView.setBackgroundResource((R.drawable.shape_corner_up));
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:开");

                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("isOn", myRoomSensorListBean);
                        readyGo(SensorActivity.class, bundle);
                    }
                });
            } else if (myRoomSensorListBean.getSecurityStatus().equals("2")) {

                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setText("温度:0℃");
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setText("光线强度:0");
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setText("湿度:0%");

                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setTextColor(Color.WHITE);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
                baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:离线");

                baseViewHolder.convertView.setBackgroundColor(Color.RED);


                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("onClick", "传感器处于离线状态,详情可以联系房东");
                    }
                });
              *//*  baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("onClick", "传感器处于离线状态,详情可以联系房东");
                    }
                });*//*
            } else {
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
                baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:关");
                baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("onClick", "开");
                    }
                });
                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("isOff", myRoomSensorListBean);
                        readyGo(SensorActivity.class, bundle);
                    }
                });
            }
        }

//        else {
//            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
//            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
//            baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
//            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("关");
//
//
//        }
//        baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
//                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
//                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setText(myRoomSensorListBean.getSensorID());
//                ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
//                ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
//                baseViewHolder.convertView.setBackgroundResource((R.drawable.shape_corner_up));
//                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("开");
//                myRoomSensorListBean.setSensorOn("true");
//            }
//        });
//        baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle =new Bundle();
//                bundle.putSerializable("isOn", myRoomSensorListBean);
//                readyGo(SensorActivity.class,bundle);
//            }
//        });
    }*/
    @Override
    protected void MyHolder(final BaseViewHolder baseViewHolder, final SensorModel.ViewDataBean myRoomSensorListBean) {
        ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_name))).setText(myRoomSensorListBean.getGateModel());
        ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setText("所在位置:" + myRoomSensorListBean.getPosition());
        ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setText("温度:" + myRoomSensorListBean.getTen() + "℃");
        ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setText("光线强度:" + myRoomSensorListBean.getLight());
        ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setText("湿度:" + myRoomSensorListBean.getWet() + "%");

        if (billListModel.getViewData().size() > 0) {
            ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
            ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
            baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
            ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:欠费停用");
            baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("onClick", "给钱");
                }
            });
            baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("onClick", "给钱");
                }
            });
        } else {
            if (myRoomSensorListBean.getSecurityStatus().equals("1")) {
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setTextColor(Color.WHITE);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
                baseViewHolder.convertView.setBackgroundResource((R.drawable.shape_corner_up));
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:开");

                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("isOn", myRoomSensorListBean);
                        readyGo(SensorActivity.class, bundle);
                    }
                });
                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("isOn", myRoomSensorListBean);
                        readyGo(SensorActivity.class, bundle);
                    }
                });
            } else if (myRoomSensorListBean.getSecurityStatus().equals("2")) {
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setText("温度:0℃");
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setText("光线强度:0");
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setText("湿度:0%");
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_tem))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_light))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_wet))).setTextColor(Color.WHITE);
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setTextColor(Color.WHITE);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
                baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:离线");


                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("onClick", "传感器处于离线状态,详情可以联系房东");
                    }
                });
                baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("onClick", "传感器处于离线状态,详情可以联系房东");
                    }
                });
            } else {
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
                ((ImageView) (baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
                baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
                ((TextView) (baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("传感器工作状态:关");
                baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("onClick", "开");
                    }
                });
                baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("isOff", myRoomSensorListBean);
                        readyGo(SensorActivity.class, bundle);
                    }
                });
            }
        }
    }
    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {

       view=layoutInflater.inflate(R.layout.frament_room,viewGroup,false);
        myScrollView = view.findViewById(R.id.my_scrollview);
        mLoading = (LoadingLayout) view.findViewById(R.id.loading_layout);

        tv_dianfei=view.findViewById(R.id.tv_dianfei);
        tv_shuifei=view.findViewById(R.id.tv_shuifei);
        tv_fangzu=view.findViewById(R.id.tv_fangzu);
        tv_result=view.findViewById(R.id.tv_result);
        tv_qita=view.findViewById(R.id.tv_qita);
        tv_title=view.findViewById(R.id.title);
        ll_yijian=view.findViewById(R.id.ll_yijian);
        view1=view.findViewById(R.id.view);

        return view;


    }

    private void showPoView(View view,String text) {
        BubblePopupWindow leftTopWindow = new BubblePopupWindow(getContext());
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View bubbleView = inflater.inflate(R.layout.layout_popup_view, null);
        TextView tvContent = (TextView) bubbleView.findViewById(R.id.tvContent);
        tvContent.setText(text);
        leftTopWindow.setBubbleView(bubbleView); // 设置气泡内容
        leftTopWindow.show(view, Gravity.TOP, 50); // 显示弹窗
        leftTopWindow.setAnimationStyle(R.style.style_pop_animation);
    }
    private void showdetil(View view) {
     final EasyPopup   mWeiboPop = EasyPopup.create()
                .setContentView(getContext(), R.layout.layout_center_pop)
                .setAnimationStyle(R.style.TopPopAnim)
                .setOnViewListener(new EasyPopup.OnViewListener() {
                    @Override
                    public void initViews(View view, EasyPopup basePopup) {
                        View arrowView = view.findViewById(R.id.v_arrow_weibo);
                        arrowView.setBackground(new TriangleDrawable(TriangleDrawable.TOP, Color.parseColor("#ed6f55")));
                    }
                })
                .setFocusAndOutsideEnable(true)
                .apply();
        int offsetY = (ll_yijian.getHeight() - view.getHeight()) / 2;
        mWeiboPop.findViewById(R.id.tv_conten1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request();
                mWeiboPop.dismiss();
            }
        });
        mWeiboPop.findViewById(R.id.tv_conten2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("entries", entries);
                            bundle.putParcelableArrayList("entries1", entries1);


                            bundle.putSerializable("viewDataBean", roomModel.getViewData().get(index));
                            readyGo(MpChartActivity.class, bundle);

            }
        });
        mWeiboPop.findViewById(R.id.tv_conten3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("entries", entries);
                bundle.putParcelableArrayList("entries1", entries1);


                bundle.putSerializable("viewDataBean", roomModel.getViewData().get(index));
                readyGo(MpChartActivity.class, bundle);
            }
        });
        mWeiboPop.showAtAnchorView(view, YGravity.BELOW, XGravity.CENTER, 0,offsetY);
    }

    @Override
    protected void initLogic() {
        EventBus.getDefault().register(this);
        mLineChart = (LineChart) view.findViewById(R.id.lineChart);
        iv_select= ((ImageView)(view.findViewById(R.id.out)));
        iv_select.setImageResource(R.drawable.room_security);


        setListener();
        request();
        recyclerView = view.findViewById(R.id.recy_pow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        powWindowAdapter=new PowWindowAdapter(getActivity());
        recyclerView.setAdapter(powWindowAdapter);
//        showPopupWindow(iv_select);

    }
    RoomInfo1 bean1;


    private void request() {


        mLoading.showContent(myScrollView);
        mLoading.showLoading();


        HttpMethods.getInstance().findRoomMessageByPhone(new BaseObserver<RoomModel>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                roomModel=(RoomModel) t;
                mAdapter.getData().clear();
                tv_title.setText(roomModel.getViewData().get(0).getMyRoomName());

                tv_fangzu.setText("房租\n"+ roomModel.getViewData().get(0).getMyRoomRent());
                tv_dianfei.setText("电费\n"+ roomModel.getViewData().get(0).getMyRoomPower());
                tv_shuifei.setText("水费\n"+roomModel.getViewData().get(0).getMyRoomWater());

                tv_qita.setText("其他\n"+roomModel.getViewData().get(0).getMyRoomTem());
                tv_result.setText("支付\n"+roomModel.getViewData().get(0).getMyRoomTotal());
                tv_fangzu.setOnClickListener(RoomFragment.this);
                tv_dianfei.setOnClickListener(RoomFragment.this);
                tv_shuifei.setOnClickListener(RoomFragment.this);
                tv_qita.setOnClickListener(RoomFragment.this);

//                for(Double water:((RoomModel) t).getViewData().get(0).getMyRoomWaterArr()){
//                    entries.add(new Entry(((RoomModel) t).getViewData().get(0).getMyRoomWaterArr().indexOf(water),water.floatValue()));
//                }
                for(int i=0;i<((RoomModel) t).getViewData().get(0).getMyRoomWaterArr().size();i++){
                    entries.add(new Entry(i,((RoomModel) t).getViewData().get(0).getMyRoomWaterArr().get(i).floatValue()));
                }

                for(int i=0;i<((RoomModel) t).getViewData().get(0).getMyRoomPowerArr().size();i++){
                    entries1.add(new Entry(i,((RoomModel) t).getViewData().get(0).getMyRoomPowerArr().get(i).floatValue()));
                }

                initMpChat(entries,entries1,6);


//查询未完成订单

//                mAdapter.addData(roomModel.getViewData().get(0).getMyRoomSensorList());
//                mLoading.dimssDoading();

                HttpMethods.getInstance().getNoCompleteBill(new BaseObserver<BillHistoryModel>() {
                    @Override
                    protected void onSuccees(BaseBean t) throws Exception {
                        billListModel = (BillHistoryModel) t;

                        if (((BillHistoryModel) t).getViewData().size()>0)
                        {
                            //界面数据处理
                        }
                        else
                        {
                            //同上
                        }
                        //查找传感器列表
                        HttpMethods.getInstance().getRoomSensorList(new BaseObserver<SensorModel>() {
                            @Override
                            protected void onSuccees(BaseBean t) throws Exception {

                                if (((SensorModel) t).getResult().equals("false"))
                                {
                                 //没有传感器数据
                                }
                                else
                                {
                                    mAdapter.addData(((SensorModel) t).getViewData());
                                }

                                mLoading.dimssDoading();
                            }
                            @Override
                            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                                mLoading.dimssDoading();
                            }
                        },UserLocalData.getUser(getContext()).getUserPhone(),roomModel.getViewData().get(0).getMyRoomID(),UserLocalData.getUser(getContext()).getTokenID(),"","","","","","");
                        Log.e("getRoomSensorList","phone="+UserLocalData.getUser(getContext()).getUserPhone());
                        Log.e("getRoomSensorList","roomid="+roomModel.getViewData().get(0).getMyRoomID());
                        Log.e("getRoomSensorList","tokenId="+UserLocalData.getUser(getContext()).getTokenID());
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mLoading.dimssDoading();
                    }
                },UserLocalData.getUser(getContext()).getUserPhone(),UserLocalData.getUser(getContext()).getUserPhone(),roomModel.getViewData().get(0).getMyRoomID(),UserLocalData.getUser(getContext()).getTokenID(),"","","","","","");

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                e.printStackTrace();

            }
        },UserLocalData.getUser(getContext()).getUserPhone(), UserLocalData.getUser(getContext()).getUserPhone(),UserLocalData.getUser(getContext()).getTokenID(),"","","","","","");

    }

    private void initMpChat(List<Entry> entries, List<Entry> entries1, final int size) {

        final List<Entry> mentries=  entries.subList(0,size);
        List<Entry>  mentries1=  entries1.subList(0,size);
        //显示边界
        mLineChart.setDrawBorders(true);
        //设置数据

        final List<String> mlistX =new ArrayList<>();

//        for(Entry entry:mentries){
//
//            mlistX.add(mentries.indexOf(entry)+1+"月");
//        }
        for(int i=0;i<size;i++){
            mlistX.add(i+1+"月");
        }

        XAxis xAxis = mLineChart.getXAxis();
        int i=0;

        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                int index = (int) value;
                if(index >= 0 && index < size ){
                    return mlistX.get(index);
                }else {
                    return "";
                }

            }
        });
        xAxis.setLabelCount(size, true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(18);

        List<ILineDataSet> sets = new ArrayList<>();
        LineDataSet  lineDataSet=     new LineDataSet(mentries, "电费");

        lineDataSet.setColor(Color.GREEN);
        sets.add(lineDataSet);

        sets.add(new LineDataSet(mentries1, "水费"));
        LineData lineData = new LineData(sets);
        Legend legend = mLineChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setTextSize(18f);
        legend.setFormSize(13);
        legend.setXEntrySpace(30f);
        mLineChart.setData(lineData);
        mLineChart.animateY(1000);




    }

    private void showPopupWindow(View view,RoomModel t) throws Exception {
        //设置contentView
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pow_layout, null);
        mPopWindow = new Solve7PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //设置各个控件的点击响应
        recyclerView=contentView.findViewById(R.id.recy_pow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        powWindowAdapter=new PowWindowAdapter(getActivity());
        recyclerView.setAdapter(powWindowAdapter);
        List<ImageText> imageTexts=new ArrayList<>();

        for(int i=0;i<   t.getViewData().size();i++) {
            if (i == 0) {
                imageTexts.add(new ImageText(t.getViewData().get(i).getMyRoomName(), true));

            } else {
                imageTexts.add(new ImageText(t.getViewData().get(i).getMyRoomName(), false));

            }

        }
        powWindowAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                try{
                    index =position;
                    entries=new ArrayList<>();
                    entries1=new ArrayList<>();
                    for(int i=0;i<roomModel.getViewData().get(position).getMyRoomWaterArr().size();i++) {
                        entries.add(new Entry(i, (roomModel.getViewData().get(position).getMyRoomWaterArr().get(i).floatValue())));
                    }
//                    tv_fangzu.setText("房租\n"+ roomModel.getViewData().get(index).getMyRoomRent());
//                    tv_dianfei.setText("电费\n"+ roomModel.getViewData().get(index).getMyRoomPower());
//                    tv_shuifei.setText("水费\n"+roomModel.getViewData().get(index).getMyRoomWater());
//
//                    tv_qita.setText("其他\n"+roomModel.getViewData().get(index).getMyRoomTem());
//                    tv_result.setText("支付\n"+roomModel.getViewData().get(index).getMyRoomTotal());
                    for(int i=0;i<(roomModel.getViewData().get(position).getMyRoomPowerArr().size());i++){
                        entries1.add(new Entry(i,(roomModel).getViewData().get(position).getMyRoomPowerArr().get(i).floatValue()));
//                        entries.add(new Entry(i,(roomModel.getViewData().get(0).getMyRoomWaterArr().get(i).floatValue())));
                    }

                    for(int i=0;i<(roomModel.getViewData().get(0).getMyRoomPowerArr().size());i++){
                        entries1.add(new Entry(i,(roomModel).getViewData().get(0).getMyRoomPowerArr().get(i).floatValue()));
                    }
                    mLineChart.notifyDataSetChanged();

                    mAdapter.getData().clear();

//                    mAdapter.addData(roomModel.getViewData().get(position).getMyRoomSensorList());
                    tv_title.setText(roomModel.getViewData().get(position).getMyRoomName());
                    tv_dianfei.setText("电费\n"+roomModel.getViewData().get(position).getMyRoomPower());
                    tv_shuifei.setText("水费\n"+roomModel.getViewData().get(position).getMyRoomWater());
                    tv_fangzu.setText("房租\n"+roomModel.getViewData().get(position).getMyRoomRent());
                    int num = Integer.parseInt(roomModel.getViewData().get(position).getMyRoomMan())+ Integer.parseInt(roomModel.getViewData().get(position).getMyRoomNet())+Integer.parseInt(roomModel.getViewData().get(position).getMyRoomServiceCharge());
                    tv_qita.setText("其他\n"+String.valueOf(num));
                    tv_result.setText("支付\n"+roomModel.getViewData().get(position).getMyRoomTotal());

                    initMpChat(entries,entries1,6);
                    //查询未完成订单
                    HttpMethods.getInstance().getNoCompleteBill(new BaseObserver<BillHistoryModel>() {
                        @Override
                        protected void onSuccees(BaseBean t) throws Exception {
                            billListModel = (BillHistoryModel) t;
//查找传感器列表
                            HttpMethods.getInstance().getRoomSensorList(new BaseObserver<SensorModel>() {
                                @Override
                                protected void onSuccees(BaseBean t) throws Exception {
                                    //这里插入传感器数据
                                    mAdapter.getData().clear();
//这里插入传感器数据
                                    if (((SensorModel) t).getResult().equals("false"))
                                    {
                                        //没有传感器数据
                                    }
                                    else
                                    {
                                        mAdapter.addData(((SensorModel) t).getViewData());
                                    }
                                    mLoading.dimssDoading();
                                    mPopWindow.dismiss();
                                }
                                @Override
                                protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                                }
                            },UserLocalData.getUser(getContext()).getUserPhone(),roomModel.getViewData().get(index).getMyRoomID(),UserLocalData.getUser(getContext()).getTokenID(),"","","","","","");
                        }

                        @Override
                        protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                        }
                    },UserLocalData.getUser(getContext()).getUserPhone(),UserLocalData.getUser(getContext()).getUserPhone(),roomModel.getViewData().get(index).getMyRoomID(),UserLocalData.getUser(getContext()).getTokenID(),"","","","","","");

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        //显示PopupWindow
        powWindowAdapter.addAll(imageTexts);
        //解决5.0以下版本点击外部不消失问题
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示方式
        mPopWindow.showAsDropDown(view);


    }
    private void setListener() {
        view.findViewById(R.id.tv_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();


                bundle.putSerializable("viewDataBean", roomModel.getViewData().get(index));
                readyGo(PayActivity.class,bundle);
            }
        });
        mLineChart.setOnChartGestureListener(new OnChartGestureListener() { // 手势监听器
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

                // 按下

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                // 抬起,取消
            }

            @Override
            public void onChartLongPressed(MotionEvent me) {
                // 长按
            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {
                // 双击
            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {
                // 单击



            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
                // 甩动
            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                // 缩放
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                // 移动
            }
        });
        view.findViewById(R.id.iv_detil)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
//                            Bundle bundle = new Bundle();
//                            bundle.putParcelableArrayList("entries", entries);
//                            bundle.putParcelableArrayList("entries1", entries1);
//
//
//                            bundle.putSerializable("viewDataBean", roomModel.getViewData().get(index));
//                            readyGo(MpChartActivity.class, bundle);

                            showdetil(view);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
        iv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick","点击了下拉按钮");


                try {

                    showPopupWindow(view1,roomModel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //PopupWindow菜单详细内容显示


    @Override
    public void onStart() {
        super.onStart();
        myScrollView.setFocusable(true);
        myScrollView.setFocusableInTouchMode(true);
        myScrollView.requestFocus();
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {
        int postion=0;
//       if( eventCenter.getEventCode()==200){
//           MyRoom.ViewDataBean.MyRoomSensorListBean bean = (MyRoom.ViewDataBean.MyRoomSensorListBean) eventCenter.getData();
//           for(MyRoom.ViewDataBean.MyRoomSensorListBean myRoomSensorListBean:mAdapter.getData()){
//               if(myRoomSensorListBean.getSensorID().equals(bean.getSensorID())){
//                   postion=mAdapter.getData().indexOf(myRoomSensorListBean);
//
//
//               }
//           }
//
//            mAdapter.setData(postion,bean);
//
//       }


    }

    @Override
    public void getChildView(View view, int layoutResId) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_fangzu:
                showPoView(view,roomModel.getViewData().get(index).getMyRoomRentDate());

                break;
            case R.id.tv_dianfei:
                showPoView(view,"电费单价:"+roomModel.getViewData().get(index).getMyRoomPowerUnivalence()+"/度\n"+"使用度数:"+roomModel.getViewData().get(index).getMyRoomPower());
             break;
            case R.id.tv_shuifei:
                showPoView(view,"水费单价:"+roomModel.getViewData().get(index).getMyRoomWaterUnivalence()+"/度\n"+"使用度数:"+roomModel.getViewData().get(index).getMyRoomWater());

                break;
            case R.id.tv_qita:
                showPoView(view,"其他包括:\n"+"管理费:"+roomModel.getViewData().get(index).getMyRoomMan()+"元"+"网费:"+roomModel.getViewData().get(index).getMyRoomNet()+"元\n"+"服务费:"+roomModel.getViewData().get(index).getMyRoomServiceCharge()+"元");
                break;

        }

    }
}
