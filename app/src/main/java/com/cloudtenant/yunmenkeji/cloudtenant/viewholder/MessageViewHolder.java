package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.FgMessage;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class MessageViewHolder extends BaseViewHolder<FgMessage> {
    private TextView name;
    private TextView fans;
    private TextView note;
    private TextView time;
    private ImageView icon;

    public MessageViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_fragment_message);
        name = $(R.id.name);
        icon = $(R.id.iv);

    }

    @Override
    public void setData(final FgMessage person){
        name.setText(person.getFamily());
        icon.setImageResource(person.getIcon());
        //name.setText(person.getName());
    }
}
