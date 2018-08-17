package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.FgMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.squareup.picasso.Picasso;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.ArrayList;
import java.util.List;

//import me.shaohui.shareutil.ShareUtil;
//import me.shaohui.shareutil.share.ShareListener;
//import me.shaohui.shareutil.share.SharePlatform;

public class ShareActivity extends YzsBaseActivity {

    private RecyclerView recyclerView;
    private   MessageAdapter messageAdapter;
    private ImageView  iv_pic;
    HouseDetil.ViewDataBean bean;
    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_share);
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));

        messageAdapter = new MessageAdapter(this);
        recyclerView.setAdapter(messageAdapter);
        iv_pic=findViewById(R.id.iv_pic);
        addData();

    }

    private void addData() {
        List<FgMessage> list=new ArrayList<>();
        list.add(new FgMessage("复制连接",R.drawable.image_share_copy));
        list.add(new FgMessage("短信",R.drawable.image_message));
        list.add(new FgMessage("微信",R.drawable.image_share_wechat));
        list.add(new FgMessage("微博",R.drawable.image_share_weibo));
        list.add(new FgMessage("更多",R.drawable.image_more));

        messageAdapter.addAll(list);
        getBundleExtras(getIntent().getExtras());
        messageAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            if(position==2){
//                ShareUtil.shareImage(ShareActivity.this
//                        , SharePlatform.QQ, "http://image.com", new ShareListener() {
//                    @Override
//                    public void shareSuccess() {
//                        showLongToast("成功");
//
//                    }
//
//                    @Override
//                    public void shareFailure(Exception e) {
//                        showLongToast("失败");
//                    }
//
//                    @Override
//                    public void shareCancel() {
//
//                    }
//                });

            }
            }
        });
    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) {
        bean = (HouseDetil.ViewDataBean) var1.getSerializable("bean");

        Picasso.with(this).load(bean.getCellImage()).fit().into(iv_pic);
    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }

    



}
