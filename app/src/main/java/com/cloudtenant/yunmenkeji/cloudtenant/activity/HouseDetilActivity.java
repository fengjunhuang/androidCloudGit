package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.HouseDetilAdater;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseListActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;

import com.yzs.yzsbaseactivitylib.entity.EventCenter;

/**
 * Created by 72984 on 2018/6/21.
 */

public class HouseDetilActivity extends YzsBaseListActivity<HouseDetil> {
    @Override
    protected void initItemLayout() {

        setLayoutResId(R.layout.item_recy_house_detil);
        setListType(LINEAR_LAYOUT_MANAGER, true);

    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, HouseDetil houseDetil) {
        RecyclerView recyclerView =baseViewHolder.convertView.findViewById(R.id.recy_floor);
        LinearLayoutManager ms= new LinearLayoutManager(this);
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        //     LinearLayoutManager 种 含有3 种布局样式  第一个就是最常用的 1.横向 , 2. 竖向,3.偏移
        recyclerView.setLayoutManager(ms);  //给RecyClerView 添加设置好的布局样式



        HouseDetilAdater houseDetilAdater =new HouseDetilAdater(this);
        recyclerView.setAdapter(houseDetilAdater);
        houseDetilAdater.add(new HouseDetil());
        houseDetilAdater.add(new HouseDetil());
        houseDetilAdater.add(new HouseDetil());
    }



    @Override
    protected void initContentView(Bundle bundle) {
        setContentView(R.layout.activity_house_detil);

    }



    @Override
    protected void initLogic() {

        mAdapter.addData(new HouseDetil());
        mAdapter.addData(new HouseDetil());
        mAdapter.addData(new HouseDetil());
        setMainText("明珠公寓");
        setSmellText("东浦新村5号");
        findViewById(R.id.out).setVisibility(View.VISIBLE);

    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public View getTitleView() {
    View view=    findViewById(R.id.include_title);
        return  findViewById(R.id.include_title);
    }

    public void setTitleView(View titleView) {
        this.titleView = titleView;
    }
    public void  setSmellText(String s){
        ((TextView) getTitleView().findViewById(R.id.tv_small)).setVisibility(View.VISIBLE);
        ((TextView) getTitleView().findViewById(R.id.tv_small)).setText(s);
    }
    public void  setMainText(String s){
        ((TextView) getTitleView().findViewById(R.id.tv_main)).setVisibility(View.VISIBLE);
        ((TextView) getTitleView().findViewById(R.id.tv_main)).setText(s);
    }
}
