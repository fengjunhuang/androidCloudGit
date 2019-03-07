package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.OtherMessageViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.OtherMessageViewHolder1;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class OtherMessageAdapter1 extends RecyclerArrayAdapter<OtherMessage.IsOverLandLordNewBean> {
    public OtherMessageAdapter1(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OtherMessageViewHolder1(parent);
    }

}
