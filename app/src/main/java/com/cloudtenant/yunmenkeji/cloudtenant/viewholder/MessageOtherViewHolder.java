package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;



/**
 * Created by Mr.Jude on 2015/2/22
 */
public class MessageOtherViewHolder extends BaseViewHolder<MessageOther.LandlordNewListBean> {
    private TextView name;
    private TextView time;


    public MessageOtherViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_message_other);
        name = $(R.id.tv_message);
        time = $(R.id.tv_time);

    }

    @Override
    public void setData(final MessageOther.LandlordNewListBean person){
        if (person.getType().equals("4")) {
         name.setText(person.getMessageContract());
        }else {
         name.setText(person.getMessageTitle());
        }
        time.setText(person.getCreateTime());

        //name.setText(person.getName());
    }
}
