package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SenerNetWork;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.CustomDatePicker;
import com.gersion.library.base.BaseActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by tlol20 on 2017/6/14
 */
public class SensorAddActivity extends BaseActivity implements View.OnClickListener{

    private SenerNetWork senerNetWork;

    private CustomDatePicker customDatePicker1,customDatePicker2;
    private TextView startTime,endTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_add);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        startTime=findViewById(R.id.tv_start_time);
        endTime=findViewById(R.id.tv_end_time);
        findViewById(R.id.start_time).setOnClickListener(this);
        findViewById(R.id.end_time).setOnClickListener(this);
        findViewById(R.id.title).setOnClickListener(this);

        senerNetWork= (SenerNetWork) getIntent().getExtras().getSerializable("bean");
        initDatePicker();
    }

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        Log.e("initDatePicker","SimpleDateFormat="+now);
        now=now+" ";
        startTime.setText(now.split(" ")[1]);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                time=time+"";
                startTime.setText(time.split(" ")[1]);
                Log.e("initDatePicker","SimpleDateFormat="+time);

            }
        }, "1970-01-01 "+senerNetWork.getViewData().get(0).getStartTime(), now,"请选择时间"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(true); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                time=time+"";
                endTime.setText(time.split(" ")[1]);
            }
        }, "1970-01-01 00:00"+senerNetWork.getViewData().get(0).getEndTime(), now,"请选择时间"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 不显示时和分
        customDatePicker2.setIsLoop(false); // 不允许循环滚动

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_time:{
                customDatePicker1.show("1970-01-01 ");
            }break;
            case R.id.end_time:{
                customDatePicker2.show("1970-01-01 ");
            }break;
            case R.id.title:{
                finish();
            }break;

        }
    }
}
