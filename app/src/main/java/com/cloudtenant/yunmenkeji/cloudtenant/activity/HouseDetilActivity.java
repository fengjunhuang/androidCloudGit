package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.HouseDetilAdater;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseListActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;

import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.List;

/**
 * Created by 72984 on 2018/6/21.
 */

public class HouseDetilActivity extends YzsBaseListActivity<BudingInfo.ViewDataBean> {
    private List<BudingInfo.ViewDataBean> viewDataX;
    HouseDetil.ViewDataBean bean;
    @Override
    protected void initItemLayout() {

        setLayoutResId(R.layout.item_recy_house_detil);
        setListType(LINEAR_LAYOUT_MANAGER, true);
        getTt_2().setText("分享");
        getBtn2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                bundle.putSerializable("bean",bean);
                    readyGo(ShareActivity.class,bundle);
            }
        });

    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, final BudingInfo.ViewDataBean houseDetil) {
        RecyclerView recyclerView =baseViewHolder.convertView.findViewById(R.id.recy_floor);
        TextView tv_floor= baseViewHolder.convertView.findViewById(R.id.tv_floor);
        tv_floor.setText(houseDetil.getFloor());
        LinearLayoutManager ms= new LinearLayoutManager(this);
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        //     LinearLayoutManager 种 含有3 种布局样式  第一个就是最常用的 1.横向 , 2. 竖向,3.偏移
        recyclerView.setLayoutManager(ms);  //给RecyClerView 添加设置好的布局样式



        HouseDetilAdater houseDetilAdater =new HouseDetilAdater(this);
        recyclerView.setAdapter(houseDetilAdater);
       houseDetilAdater.addAll(houseDetil.getData());
        houseDetilAdater.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle =new Bundle();
                bundle.putSerializable("bean",houseDetil.getData().get(position));
                readyGo(TnementAcitivity_.class,bundle);
            }
        });
    }



    @Override
    protected void initContentView(Bundle bundle) {
        setContentView(R.layout.activity_house_detil);

    }



    @Override
    protected void initLogic() {


        getBtn1();
        getBtn2();

        findViewById(R.id.out).setVisibility(View.VISIBLE);
        (getTt_1()).setText("导航");
        (getBtn1()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readyGo(RoutingActivity.class);
            }
        });
        requset();
        getBundleExtras(getIntent().getExtras());
    }

    private void requset() {
        HttpMethods.getInstance().BudingInfo(new BaseObserver<BudingInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                BudingInfo budingInfo= (BudingInfo) t;
               viewDataX = budingInfo.getViewDataX();
               mAdapter.addData(viewDataX);


                System.out.print("");

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {
       bean = (HouseDetil.ViewDataBean) bundle.getSerializable("bean");
        setMainText(bean.getCellName());
        setSmellText(bean.getCellAddress());
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
