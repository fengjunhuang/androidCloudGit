package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MessageOtherViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.OtherMessageViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class OtherMessageAdapter extends RecyclerArrayAdapter<OtherMessage.NoOverLandLordNewBean> {
    public OtherMessageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OtherMessageViewHolder(parent);
    }

}
