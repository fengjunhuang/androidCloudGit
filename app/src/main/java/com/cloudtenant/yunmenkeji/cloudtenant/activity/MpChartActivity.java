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
    @Override
    protected void initContentView(Bundle var1) {


        setContentView(R.layout.activity_mp_chart);
        mViewPager=findViewById(R.id.slidebar_viewPager);
      mpChartAdapter = new MpChartAdapter();
        mViewPager.setAdapter(new MpChartAdapter());
        mpChartAdapter.notifyDataSetChanged();


    }
  private  View pieMpChat(View view){
      //饼状图
      PieChart mPieChart = (PieChart)  view.findViewById(R.id.mPieChart);
      mPieChart.setUsePercentValues(true);
      mPieChart.getDescription().setEnabled(false);
      mPieChart.setExtraOffsets(5, 10, 5, 5);

      mPieChart.setDragDecelerationFrictionCoef(0.95f);
      //设置中间文件
//      mPieChart.setCenterText(generateCenterSpannableText());

      mPieChart.setDrawHoleEnabled(true);
      mPieChart.setHoleColor(Color.WHITE);

      mPieChart.setTransparentCircleColor(Color.WHITE);
      mPieChart.setTransparentCircleAlpha(110);
      mPieChart.getLegend().setFormSize(14);
      mPieChart.setDrawSliceText(true);
      //设置图列标识文字的大小
      mPieChart.getLegend().setTextSize(14);

      mPieChart.setHoleRadius(58f);
      mPieChart.setTransparentCircleRadius(61f);
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

      //模拟数据
      ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
      entries.add(new PieEntry(10, "水费"));
      entries.add(new PieEntry(249, "电费"));
      entries.add(new PieEntry(6, "管理费"));
      entries.add(new PieEntry(50, "网费"));
      entries.add(new PieEntry(800, "房租"));
      //设置数据
      setData(entries,mPieChart);

      mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

      Legend l = mPieChart.getLegend();
      l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
      l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
      l.setOrientation(Legend.LegendOrientation.VERTICAL);
      l.setDrawInside(false);
      l.setXEntrySpace(7f);
      l.setYEntrySpace(0f);
      l.setYOffset(0f);

      return mPieChart;
  }

  //设置数据
    private void setData(ArrayList<PieEntry> entries,PieChart mPieChart) {
        PieDataSet dataSet = new PieDataSet(entries, "金额");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        //数据和颜色
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15f);

        mPieChart.setData(data);
        mPieChart.highlightValues(null);
        //刷新
        mPieChart.invalidate();
    }
    private  View MpinitMpChat(View view) {

        LineChart mLineChart=  view.findViewById(R.id.lineChart);
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
        LineDataSet lineDataSet=     new LineDataSet(entries, "电费");

        lineDataSet.setColor(Color.GREEN);
        sets.add(lineDataSet);

        sets.add(new LineDataSet(entries1, "水费"));
        LineData lineData = new LineData(sets);
        Legend legend = mLineChart.getLegend();
        legend.setTextSize(18f);
        legend.setFormSize(13);
        mLineChart.setData(lineData);
        mLineChart.animateY(1000);
        return mLineChart;

    }


    @Override
    protected void initView() {

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
            View  containView =LayoutInflater.from(MpChartActivity.this).inflate(R.layout.item_mp_chart,null);
            MpinitMpChat(containView);
           container.addView(containView);
                return  containView;

            }else {
                View  containView =LayoutInflater.from(MpChartActivity.this).inflate(R.layout.item_pie_chart,null);
                pieMpChat(containView);
                container.addView(containView);
                return  containView;
            }

            }
        }


}
