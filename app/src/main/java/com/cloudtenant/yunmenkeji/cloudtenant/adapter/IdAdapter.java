package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherId;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MessageOtherViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.OtherIdViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class IdAdapter extends RecyclerArrayAdapter<OtherId> {
    public IdAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OtherIdViewHolder(parent);
    }

}
