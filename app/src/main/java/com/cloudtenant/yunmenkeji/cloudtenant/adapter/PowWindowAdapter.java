package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.FgMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ImageText;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MessageViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.TextViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class PowWindowAdapter extends RecyclerArrayAdapter<ImageText> {
    public PowWindowAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextViewHolder(parent);
    }

}
