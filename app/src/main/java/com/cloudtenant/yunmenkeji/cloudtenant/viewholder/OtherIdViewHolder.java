package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherId;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class OtherIdViewHolder extends BaseViewHolder<OtherId> {
    private TextView name;


    public OtherIdViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_other_id);
        name = $(R.id.tv_message);

    }

    @Override
    public void setData(OtherId data){
        name.setText(data.getName());

        //name.setText(person.getName());
    }
}
