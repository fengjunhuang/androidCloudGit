package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MessageOtherActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MessageRoomActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.RequestActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ContractAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.FgMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.model.Indexdata;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BannerPicassoImageLoader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.SpacesItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.youth.banner.Banner;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends YzsBaseListFragment<Indexdata> implements View.OnClickListener {




    private EasyRecyclerView recyclerView;
    private MessageAdapter adapter;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.down: {
                if (flag){
                    fenlei.setVisibility(View.GONE);
                    gridView.setVisibility(View.GONE);
                    flag=false;
                }else {
                    fenlei.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.VISIBLE);
                    flag=true;
                }
            }break;*/

        }
    }

    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
       View view=layoutInflater.inflate(R.layout.fragment_message,viewGroup,false);
        recyclerView= (EasyRecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new MessageAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        //getData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                            case 0: {
                                startActivity(new Intent(getActivity(), MessageRoomActivity.class));
                                 }break;
                            case 1: {
                                startActivity(new Intent(getActivity(), MessageOtherActivity.class));
                                 }break;
                }
            }
        });
        AddData();
        return view;
    }

    @Override
    protected void initView(View view) {
        //super.initView(view);

    }

    @Override
    protected void initItemLayout() {


    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, Indexdata indexdata) {

    }


    private void AddData() {
        List<FgMessage> list=new ArrayList<>();
        list.add(new FgMessage("来自房间的安防",R.drawable.image_message_save));
        list.add(new FgMessage("来自其他",R.drawable.image_message_other));
        adapter.addAll(list);
    }
    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
