package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

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

    public NoticeViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_notice);
        name = $(R.id.messageInfo);
        time = $(R.id.time);
        textView = $(R.id.title);

        textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    @Override
    public void setData(final NoticeHistory.ViewDataBean person){


        name.setText(person.getMessageInfo());
        time.setText(person.getMessageTime());
    }
}
