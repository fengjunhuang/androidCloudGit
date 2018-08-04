package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.NoticeHistory;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class NoticeViewHolder extends BaseViewHolder<NoticeHistory.ViewDataBean> {
    private TextView name;
    private TextView time;
    private TextView textView;
    private TextView tv_type;

    public NoticeViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_message_room);
        name = $(R.id.tv_message);
        time = $(R.id.tv_time);
        tv_type = $(R.id.tv_type);

    }

    @Override
    public void setData(final NoticeHistory.ViewDataBean person){


        name.setText(person.getMessageInfo());
        tv_type.setTextColor(getContext().getResources().getColor(R.color.gren_cut_clorr));
        time.setText(person.getMessageTime());
        time.setTextColor(Color.BLACK);
    }
}
