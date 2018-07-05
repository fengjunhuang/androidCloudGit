package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.ContractViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MyFamilyViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class ContractAdapter extends RecyclerArrayAdapter<MyContract.ViewDataBean> {
    public ContractAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContractViewHolder(parent);
    }

}
