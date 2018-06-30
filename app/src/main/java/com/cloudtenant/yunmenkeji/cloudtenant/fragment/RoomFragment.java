package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MpChartActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.SensorActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
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
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import java.util.ArrayList;
import java.util.List;

public class RoomFragment extends YzsBaseListFragment<HouseDetil> {

    LineChart mLineChart;
    View myScrollView;
    @Override
    protected void initItemLayout() {
        setLayoutResId(R.layout.item_safe_sensor);
        setListType(LINEAR_LAYOUT_MANAGER, false);

    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, HouseDetil houseDetil) {
            baseViewHolder.convertView.findViewById(R.id.iv_my_room_cell).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(),SensorActivity.class));
                }
            });
    }

    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {

        View view=layoutInflater.inflate(R.layout.frament_room,viewGroup,false);
         myScrollView = view.findViewById(R.id.my_scrollview);

        return view;
    }

    @Override
    protected void initLogic() {
         initMpChat();
        setListener();
    }

    private void initMpChat() {

        mLineChart = (LineChart) view.findViewById(R.id.lineChart);
        //显示边界
        mLineChart.setDrawBorders(true);
        //设置数据
        List<Entry> entries = new ArrayList<>();
        List<Entry> entries1 = new ArrayList<>();
        final List<String> mlistX =new ArrayList<>();
        mlistX.add("1月");
        mlistX.add("2月");
        mlistX.add("3月");
        mlistX.add("4月");
        mlistX.add("5月");
        mlistX.add("6月");
        mlistX.add("7月");
        mlistX.add("8月");
        mlistX.add("9月");
        mlistX.add("10月");
        mlistX.add("11月");
        mlistX.add("12月");
        entries.add(new Entry(0, 30f));
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
        entries1.add(new Entry(11, 19f));
        //一个LineDataSet就是一条线
        XAxis xAxis = mLineChart.getXAxis();

        xAxis.setValueFormatter(new IAxisValueFormatter() {


            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return mlistX.get((int) value);
            }
        });

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(18);

        List<ILineDataSet> sets = new ArrayList<>();
        LineDataSet  lineDataSet=     new LineDataSet(entries, "电费");

        lineDataSet.setColor(Color.GREEN);
        sets.add(lineDataSet);

        sets.add(new LineDataSet(entries1, "水费"));
        LineData lineData = new LineData(sets);
        Legend legend = mLineChart.getLegend();
        legend.setTextSize(18f);
        legend.setFormSize(13);
        mLineChart.setData(lineData);
        mLineChart.animateY(1000);
        mAdapter.addData(new HouseDetil());
        mAdapter.addData(new HouseDetil());
        mAdapter.addData(new HouseDetil());
    }

    private void setListener() {
        mLineChart.setOnChartGestureListener(new OnChartGestureListener() { // 手势监听器
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

                // 按下
                readyGo(MpChartActivity.class);
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
    }


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

    }
}
