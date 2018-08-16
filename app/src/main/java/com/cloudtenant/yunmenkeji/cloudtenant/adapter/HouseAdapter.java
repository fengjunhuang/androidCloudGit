package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.NewHomeFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.ContractViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.EmptyViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.HouseViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class HouseAdapter extends RecyclerArrayAdapter<Object> {
    public static final int TYPE_INVALID = 0;
    HouseViewHolder viewHolder=null;
    private boolean isShow= NewHomeFragment.isMapMode;
    public HouseAdapter(Context context) {
        super(context);
    }
    @Override
    public int getViewType(int position) {
        if(getItem(position) instanceof HouseDetil.ViewDataBean){
            return TYPE_INVALID;
        }else {
            return 1;
        }

    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("OnCreateViewHolder","isShow="+isShow+">>>viewType="+viewType);
        if (viewType==TYPE_INVALID) {
            viewHolder=new HouseViewHolder(parent);
            return viewHolder;
        }else {
            return new EmptyViewHolder(parent);
        }

    }



}
