package com.cloudtenant.yunmenkeji.cloudtenant.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;

public class CustomDialog extends Dialog {

    /**
     * 提示
     */
    protected TextView hintTv;

    /**
     * 左边按钮
     */
    protected TextView doubleLeftBtn;

    /**
     * 右边按钮
     */
    protected TextView doubleRightBtn;

    public CustomDialog(Context context) {
        super(context, R.style.CustomDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(false);  // 是否可以撤销
        setContentView(R.layout.dialog_custom);
        hintTv = (TextView) findViewById(R.id.data);
        doubleLeftBtn = findViewById(R.id.btn_common_dialog_double_left);
        doubleRightBtn = findViewById(R.id.btn_common_dialog_double_right);
    }

    /**
     * 设置右键文字和点击事件
     *
     * @param rightStr 文字
     * @param clickListener 点击事件
     */
    public void setRightButton(String rightStr, View.OnClickListener clickListener) {
        doubleRightBtn.setOnClickListener(clickListener);
        doubleRightBtn.setText(rightStr);
    }

    /**
     * 设置左键文字和点击事件
     *
     * @param leftStr 文字
     * @param clickListener 点击事件
     */
    public void setLeftButton(String leftStr, View.OnClickListener clickListener) {
        doubleLeftBtn.setOnClickListener(clickListener);
        doubleLeftBtn.setText(leftStr);
    }
    /**
     * 设置文字和点击事件
     *
     * @param leftStr 文字
     * @param clickListener 点击事件
     */
    public void setDataClick(String leftStr, View.OnClickListener clickListener) {
        hintTv.setOnClickListener(clickListener);
        //hintTv.setText(leftStr);
    }

    /**
     * 设置提示内容
     *
     * @param str 内容
     */
    public void setHintText(String str) {
        hintTv.setText(str);
        hintTv.setTextColor(Color.BLUE);
        hintTv.setVisibility(View.VISIBLE);
    }

    /**
     * 给两个按钮 设置文字
     *
     * @param leftStr 左按钮文字
     * @param rightStr 右按钮文字
     */
    public void setBtnText(String leftStr, String rightStr) {
        doubleLeftBtn.setText(leftStr);
        doubleRightBtn.setText(rightStr);
    }
}