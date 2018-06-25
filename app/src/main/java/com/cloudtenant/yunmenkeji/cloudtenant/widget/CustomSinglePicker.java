package com.cloudtenant.yunmenkeji.cloudtenant.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;

import java.util.ArrayList;

/**
 * Created by liuwan on 2016/9/28.
 */
public class CustomSinglePicker {

    /**
     * 定义结果回调接口
     */
    public interface ResultHandler {
        void handle(String time);
    }

    public enum SCROLL_TYPE {
        HOUR(1),
        MINUTE(2);

        SCROLL_TYPE(int value) {
            this.value = value;
        }

        public int value;
    }


    private ResultHandler handler;
    private Context context;
    private boolean canAccess = false;

    private Dialog datePickerDialog;
    private DatePickerView year_pv;



    private ArrayList<String> year;

    private TextView tv_cancle, tv_select;
    private String selectedString,title;
    public CustomSinglePicker(Context context, ResultHandler resultHandler, ArrayList<String> startDate, String title) {

            canAccess = true;
            this.context = context;
            this.handler = resultHandler;
            this.title=title;
            initDialog();
            initView();
            initArrayList(startDate);

    }

    private void initDialog() {
        if (datePickerDialog == null) {
            datePickerDialog = new Dialog(context, R.style.time_dialog);
            datePickerDialog.setCancelable(false);
            datePickerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            datePickerDialog.setContentView(R.layout.custom_single_picker);
            TextView tv_title= (TextView) datePickerDialog.findViewById(R.id.tv_title);
            if (title!=null) {
                tv_title.setText(title);
            }
            Window window = datePickerDialog.getWindow();
            window.setGravity(Gravity.BOTTOM);
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(dm);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = dm.widthPixels;
            window.setAttributes(lp);
        }
    }

    private void initView() {
        year_pv = (DatePickerView) datePickerDialog.findViewById(R.id.year_pv);

        tv_cancle = (TextView) datePickerDialog.findViewById(R.id.tv_cancle);
        tv_select = (TextView) datePickerDialog.findViewById(R.id.tv_select);
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.dismiss();
            }
        });

        tv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handler.handle(selectedString);
                datePickerDialog.dismiss();
            }
        });
    }



    private void initArrayList( ArrayList<String> startDate) {
        if (year == null) year = new ArrayList<>();
        year.clear();
        for (int i = 0; i < startDate.size(); i++) {
            year.add(startDate.get(i));
        }
        if (year.size()>0) {
            selectedString=year.get(0);
        }
        loadComponent();
    }

    private void loadComponent() {
        year_pv.setData(year);

        year_pv.setSelected(0);

        executeScroll();
    }

    private void addListener() {
        year_pv.setOnSelectListener(new DatePickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                selectedString=text;
            }
        });

    }



    private void executeScroll() {
        year_pv.setCanScroll(year.size() > 1);

    }


    public void show(String time) {
        if (canAccess) {
                    canAccess = true;
                    addListener();
                    setSelectedTime(time);
                    datePickerDialog.show();
        }
    }



    /**
     * 设置日期控件是否可以循环滚动
     */
    public void setIsLoop(boolean isLoop) {
        if (canAccess) {
            this.year_pv.setIsLoop(isLoop);
        }
    }

    /**
     * 设置日期控件默认选中的时间
     */
    public void setSelectedTime(String time) {
        if (canAccess) {

            year_pv.setSelected(time);
            selectedString=time;

            executeScroll();
        }
    }



}
