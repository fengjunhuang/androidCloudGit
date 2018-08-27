package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;

import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.view.CharPicPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.gersion.library.base.BaseActivity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.youth.banner.Banner;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.ArrayList;
import java.util.List;

public class MpChartActivity extends YzsBaseActivity {

    ViewPager mViewPager;
    MpChartAdapter mpChartAdapter;
    ArrayList<Entry> entries;
    ArrayList<Entry> entries1;
    MyRoom.ViewDataBean viewDataBean;
    CharPicPopupWindow mPopWindow;
    LineChart mLineChart;
    View  containView;
   public static final int[] PIE_COLORS = {
           Color.rgb(75, 208, 250),
           Color.rgb(141, 207, 109),
           Color.rgb(115, 120, 204),
           Color.rgb(252, 114, 86),
           Color.rgb(255, 184, 96)
   };

    private void showPopupWindow() {
        //设置contentView
        mPopWindow = new CharPicPopupWindow(this, new CharPicPopupWindow.OnClickListen() {
            @Override
            public void onClick(View view, int pos) {
                if(pos==0){
                    initMpChat(entries,entries1,12);

                }else if(pos==1){
                    MpinitMpChat(containView,6);
                }else  if(pos ==2){
                    initMpChat(entries,entries1,3);
                }else if(pos==3){


                }
                mPopWindow.dismiss();
            }
        }, 2);
        mPopWindow.showAsDropDown(LayoutInflater.from(this).inflate(R.layout.activity_mp_chart, null));

    }

    @Override
    protected void initContentView(Bundle var1) {


        setContentView(R.layout.activity_mp_chart);
        getBundleExtras(getIntent().getExtras());
        mViewPager=findViewById(R.id.slidebar_viewPager);
      mpChartAdapter = new MpChartAdapter();
        mViewPager.setAdapter(new MpChartAdapter());
        mpChartAdapter.notifyDataSetChanged();
    findViewById(R.id.iv_refesh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
  private  View pieMpChat(View view, ArrayList<PieEntry> entries,int rep){
      //饼状图
      PieChart mPieChart = (PieChart)  view.findViewById(R.id.mPieChart);
      mPieChart.setUsePercentValues(true);
      mPieChart.setDrawEntryLabels(false);
      mPieChart.getDescription().setEnabled(false);
      mPieChart.setExtraOffsets(5, 10, 5, 5);
      mPieChart.setUsePercentValues(true);
      mPieChart.setDragDecelerationFrictionCoef(0.95f);
      //设置中间文件
//      mPieChart.setCenterText(generateCenterSpannableText());
      mPieChart.setDrawSliceText(false);//设置隐藏饼图上
      mPieChart.setDrawHoleEnabled(true);
      mPieChart.setHoleColor(Color.WHITE);

      mPieChart.setTransparentCircleColor(Color.WHITE);
      mPieChart.setTransparentCircleAlpha(110);
      mPieChart.getLegend().setFormSize(14);

      //设置图列标识文字的大小
      mPieChart.getLegend().setTextSize(12);


      mPieChart.setTransparentCircleRadius(28f);
      mPieChart.animateX(1400);
      mPieChart.setDrawCenterText(true);

      mPieChart.setRotationAngle(0);
      // 触摸旋转
      mPieChart.setRotationEnabled(true);
      mPieChart.setHighlightPerTapEnabled(true);

      //变化监听
      mPieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
          @Override
          public void onValueSelected(Entry e, Highlight h) {

          }

          @Override
          public void onNothingSelected() {

          }
      });
      mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);// 设置pieChart图表展示动画效果
      //模拟数据

      //设置数据
      setData(entries,mPieChart);

      mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

      Legend l = mPieChart.getLegend();
      l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
      l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
      l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
      l.setDrawInside(false);
      l.setXEntrySpace(7f);
      l.setFormSize(10);
      l.setYEntrySpace(8f);
      l.setYOffset(0f);



      return mPieChart;
  }

  //设置数据
    private void setData(ArrayList<PieEntry> entries,PieChart mPieChart) {
        PieDataSet dataSet = new PieDataSet(entries, "金额");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setValueLinePart1OffsetPercentage(100f);//数据连接线距图形片内部边界的距离，为百分数
        dataSet.setValueLinePart1Length(0.3f);
        dataSet.setValueLinePart2Length(0.4f);

        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        //数据和颜色
//        ArrayList<Integer> colors = new ArrayList<Integer>();
//        for (int c : ColorTemplate.VORDIPLOM_COLORS)
//            colors.add(c);
//        for (int c : ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);
//        for (int c : ColorTemplate.COLORFUL_COLORS)
//            colors.add(c);
//        for (int c : ColorTemplate.LIBERTY_COLORS)
//            colors.add(c);
//        for (int c : ColorTemplate.PASTEL_COLORS)
//            colors.add(c);
//        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(PIE_COLORS);//设置饼块的颜色

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15f);

        mPieChart.setData(data);
        mPieChart.highlightValues(null);
        //刷新
        mPieChart.invalidate();
    }
    private  View MpinitMpChat(View view,int pos) {
 if(mLineChart!=null){
     mLineChart.invalidate();
 }
      mLineChart=  view.findViewById(R.id.lineChart);
        //显示边界
     initMpChat(entries,entries1,pos);
        return mLineChart;

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
        //一个LineDataSet就是一条线\

        XAxis xAxis = mLineChart.getXAxis();

        xAxis.setLabelCount(size, true);
//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//
//
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//
//                return mlistX.get((int) value);
//            }
//        });

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
    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) {

     entries=  var1.getParcelableArrayList("entries");
      entries1=  var1.getParcelableArrayList("entries1");
        viewDataBean = (MyRoom.ViewDataBean) var1.getSerializable("viewDataBean");

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }

 class MpChartAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//          if (object instanceof ScaleView) {
//              ScaleView scaleView = (ScaleView) object;
//              container.removeView(scaleView);
//          }
//            container.removeView(mScaleViews[position]);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if(position==0){
            containView =LayoutInflater.from(MpChartActivity.this).inflate(R.layout.item_mp_chart,null);
            MpinitMpChat(containView,12);

           container.addView(containView);
                return  containView;

            }else {
                View  containView =LayoutInflater.from(MpChartActivity.this).inflate(R.layout.item_pie_chart,null);
                ArrayList<PieEntry>       entries = new ArrayList<PieEntry>();
                entries.add(new PieEntry(Float.valueOf(viewDataBean.getMyRoomWater()), "水费"+viewDataBean.getMyRoomWater()+"元"));
                entries.add(new PieEntry(Float.valueOf(viewDataBean.getMyRoomPower()), "电费"+viewDataBean.getMyRoomPower()+"元"));
                entries.add(new PieEntry(Float.valueOf(viewDataBean.getMyRoomMan()), "管理费"+viewDataBean.getMyRoomMan()+"元"));
                entries.add(new PieEntry(Float.valueOf(viewDataBean.getMyRoomNet()), "网费"+viewDataBean.getMyRoomNet()+"元"));
                entries.add(new PieEntry(Float.valueOf(viewDataBean.getMyRoomTotal()), "房租"+viewDataBean.getMyRoomTotal()+"元"));

                pieMpChat(containView,entries,1);

                container.addView(containView);
                return  containView;
            }

            }
        }


}
