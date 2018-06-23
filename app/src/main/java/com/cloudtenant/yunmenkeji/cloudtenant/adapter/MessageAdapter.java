package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.FgMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.ContractViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MessageViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class MessageAdapter extends RecyclerArrayAdapter<FgMessage> {
    public MessageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(parent);
    }

}
