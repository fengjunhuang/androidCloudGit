package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ImageText;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.model.NewBaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.NewBaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.view.CommonPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.LoadingLayout;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.Solve7PopupWindow;
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
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomFragment extends YzsBaseListFragment< RoomModel.ViewDataBean.MyRoomSensorListBean> implements CommonPopupWindow.ViewInterface{
    LineChart mLineChart;
    View myScrollView;

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
    private  TextView  tv_title;
    private  LinearLayout ll_yijian;
    private  View view1;
    private  int index;
    private  RoomModel roomModel;
    private List<Map<String, Object>> riskAreaList = null;

    @Override
    protected void initItemLayout() {
        setLayoutResId(R.layout.item_safe_sensor);
        setListType(LINEAR_LAYOUT_MANAGER, false);

    }

    @Override
    protected void MyHolder(final BaseViewHolder baseViewHolder, final RoomModel.ViewDataBean.MyRoomSensorListBean myRoomSensorListBean) {
        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_name))).setText(myRoomSensorListBean.getSensorName());
        ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setText(myRoomSensorListBean.getSensorID());
        if(myRoomSensorListBean.getSensorOn().equals("true")){
            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setText(myRoomSensorListBean.getSensorID());
            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
            baseViewHolder.convertView.setBackgroundResource((R.drawable.shape_corner_up));
            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("开");

            baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("isOn", myRoomSensorListBean);
                    readyGo(SensorActivity.class,bundle);
                }
            });
        }
        else {
            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_off);
            ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_off);
            baseViewHolder.convertView.setBackground(getResources().getDrawable(R.drawable.shape_corner_down));
            ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("关");


        }
        baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_name))).setTextColor(Color.WHITE);
                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setTextColor(Color.WHITE);
                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_sensorID))).setText(myRoomSensorListBean.getSensorID());
                ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_sign))).setImageResource(R.drawable.image_myroom_open);
                ((ImageView)(baseViewHolder.convertView.findViewById(R.id.iv_senicon))).setImageResource(R.drawable.image_sensor_status_on);
                baseViewHolder.convertView.setBackgroundResource((R.drawable.shape_corner_up));
                ((TextView)(baseViewHolder.convertView.findViewById(R.id.tv_switch))).setText("开");
                myRoomSensorListBean.setSensorOn("true");
            }
        });
        baseViewHolder.convertView.findViewById(R.id.iv_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                bundle.putSerializable("isOn", myRoomSensorListBean);
                readyGo(SensorActivity.class,bundle);
            }
        });
    }


    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {

        View view=layoutInflater.inflate(R.layout.frament_room,viewGroup,false);
         myScrollView = view.findViewById(R.id.my_scrollview);
        mLoading = (LoadingLayout) view.findViewById(R.id.loading_layout);
        mLoading.showContent(myScrollView);
        mLoading.showLoading();
        tv_dianfei=view.findViewById(R.id.tv_dianfei);
        tv_shuifei=view.findViewById(R.id.tv_shuifei);
        tv_fangzu=view.findViewById(R.id.tv_fangzu);
        tv_qita=view.findViewById(R.id.tv_qita);
        tv_title=view.findViewById(R.id.title);
        ll_yijian=view.findViewById(R.id.ll_yijian);
        view1=view.findViewById(R.id.view);
        return view;
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

    private void request() {
        HttpMethods.getInstance().findRoomMessageByPhone(new BaseObserver<RoomModel>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                roomModel=(RoomModel) t;



                for(Double water:((RoomModel) t).getViewData().get(0).getMyRoomWaterArr()){
                    entries.add(new Entry(((RoomModel) t).getViewData().get(0).getMyRoomWaterArr().indexOf(water),water.floatValue()));
                }
                for(Double power:((RoomModel) t).getViewData().get(0).getMyRoomPowerArr()){
                    entries1.add(new Entry(((RoomModel) t).getViewData().get(0).getMyRoomPowerArr().indexOf(power),power.floatValue()));
                }
                initMpChat(entries,entries1,6);

                mAdapter.addData(roomModel.getViewData().get(0).getMyRoomSensorList());
                mLoading.dimssDoading();
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                e.printStackTrace();

            }
        },"13068893276");
//        HttpMethods.getInstance().myRoom(new BaseObserver<MyRoom>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                 myRoom=(MyRoom)t;
//                  initRoomData(myRoom.getViewDataX().get(0));
//
//                for(Integer water:((MyRoom) t).getViewDataX().get(0).getMyRoomWaterArr()){
//                    entries.add(new Entry(((MyRoom) t).getViewDataX().get(0).getMyRoomWaterArr().indexOf(water),water.floatValue()));
//                }
//                for(Integer power:((MyRoom) t).getViewDataX().get(0).getMyRoomPowerArr()){
//                    entries1.add(new Entry(((MyRoom) t).getViewDataX().get(0).getMyRoomPowerArr().indexOf(power),power.floatValue()));
//                }
//                initMpChat(entries,entries1,6);
//
//                mAdapter.addData(myRoom.getViewDataX().get(0).getMyRoomSensorList());
//                mLoading.dimssDoading();
//
//
//            }
//
//            private void initRoomData(MyRoom.ViewDataBean viewDataBean) {
//
//
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//                mLoading.showState();
//
//            }
//        },"");
    }

    private void initMpChat( List<Entry> entries,List<Entry> entries1,int size) {

        List<Entry> mentries=  entries.subList(0,size);
        List<Entry>  mentries1=  entries1.subList(0,size);
        //显示边界
        mLineChart.setDrawBorders(true);
        //设置数据

        final List<String> mlistX =new ArrayList<>();

        for(Entry entry:mentries){
            mlistX.add((int) entry.getX()+1+"月");

        }

       /* entries.add(new Entry(0, 30f));
        entries.add(new Entry(1, 50f));
        entries.add(new Entry(2, 81f));
        entries.add(new Entry(3, 46f));
        entries.add(new Entry(4, 204f));
        entries.add(new Entry(5, 290f));
        entries.add(new Entry(6, 310f));
        entries.add(new Entry(7, 259f));
        entries.add(new Entry(8, 530f));
        entries.add(new Entry(9, 430f));
        entries.add(new Entry(10, 498f));
        entries.add(new Entry(11, 431f));
        entries1.add(new Entry(0, 14f));
        entries1.add(new Entry(1, 16f));
        entries1.add(new Entry(2, 11f));
        entries1.add(new Entry(3, 12f));
        entries1.add(new Entry(4, 18f));
        entries1.add(new Entry(5, 10f));
        entries1.add(new Entry(6, 21f));
        entries1.add(new Entry(7, 32f));
        entries1.add(new Entry(8, 17f));
        entries1.add(new Entry(9, 12f));
        entries1.add(new Entry(10, 17f));
        entries1.add(new Entry(11, 19f));*/
        //一个LineDataSet就是一条线
        XAxis xAxis = mLineChart.getXAxis();

        xAxis.setValueFormatter(new IAxisValueFormatter() {


            @Override
            public String getFormattedValue(float value, AxisBase axis) {

//                return mlistX.get((int) value-1);
                return "1";
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
                   for(Double water:((RoomModel) roomModel).getViewData().get(position).getMyRoomWaterArr()){
                       entries.add(new Entry(((RoomModel) roomModel).getViewData().get(position).getMyRoomWaterArr().indexOf(water),water.floatValue()));
                   }
                   for(Double power:((RoomModel) roomModel).getViewData().get(position).getMyRoomPowerArr()){
                       entries1.add(new Entry(((RoomModel) roomModel).getViewData().get(position).getMyRoomPowerArr().indexOf(power),power.floatValue()));
                   }
                   mLineChart.notifyDataSetChanged();

                   mAdapter.getData().clear();
                   mAdapter.addData(roomModel.getViewData().get(position).getMyRoomSensorList());
                   tv_title.setText(roomModel.getViewData().get(position).getMyRoomName());
                   initMpChat(entries,entries1,6);
                   mPopWindow.dismiss();

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
                readyGo(PayActivity.class);
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
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("entries", entries);
                bundle.putParcelableArrayList("entries1", entries1);


                    bundle.putSerializable("viewDataBean", roomModel.getViewData().get(index));
                    readyGo(MpChartActivity.class, bundle);
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
}
