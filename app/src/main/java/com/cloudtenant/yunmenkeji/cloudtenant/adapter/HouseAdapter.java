package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.ContractViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.EmptyViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.HouseViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class HouseAdapter extends RecyclerArrayAdapter<HouseDetil.ViewDataBean> {
    HouseViewHolder viewHolder=null;
    boolean isShow= PreferencesUtils.getBoolean(getContext(),"isShow");
    public HouseAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        if (isShow) {
            viewHolder=new HouseViewHolder(parent);
            return viewHolder;
        }else {
            return new EmptyViewHolder(parent);
        }

    }



}
