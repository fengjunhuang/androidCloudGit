package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class MessageRoomViewHolder extends BaseViewHolder<MessageSave.ViewDataBean.MessageArrayBean> {
    private TextView name;
    private TextView time;
    private TextView tv_type;
    private ImageView iv_icon;


    public MessageRoomViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_message_room);
        name = $(R.id.tv_message);
        time = $(R.id.tv_time);
        iv_icon = $(R.id.iv_icon);
        tv_type = $(R.id.tv_type);

        tv_type.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    @Override
    public void setData(final MessageSave.ViewDataBean.MessageArrayBean person){
        if (getAdapterPosition()==0) {
            iv_icon.setImageResource(R.drawable.image_message_notice);
            tv_type.setTextColor(getContext().getResources().getColor(R.color.gren_cut_clorr));
            tv_type.setText("公告");
        }else {
            /*if (person.getMessageWarningStatus()!=0){
                iv_icon.setImageResource(R.drawable.demoimage);
                tv_type.setTextColor(getContext().getResources().getColor(R.color.gren_cut_clorr));
                tv_type.setText("安全");
            }else {
                iv_icon.setImageResource(R.drawable.image_message_warning);
                tv_type.setTextColor(getContext().getResources().getColor(R.color.red_cut_clorr));
                tv_type.setText("危險");

            }*/
        }

        name.setText(person.getMessageNotice());
        time.setText(person.getMessageWarningTime());

        //name.setText(person.getName());
    }
}
