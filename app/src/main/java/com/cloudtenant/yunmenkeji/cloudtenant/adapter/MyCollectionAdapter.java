package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyCollection;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MyCollectionViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.viewholder.MyFamilyViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class MyCollectionAdapter extends RecyclerArrayAdapter<MyCollection.ViewDataBean> {
    public MyCollectionAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyCollectionViewHolder(parent);
    }

}
