package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class RoomMessageViewHolder extends BaseViewHolder<SensorModel.ViewDataBean> {
    private TextView name;
    private TextView time;


    public RoomMessageViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_room_message);
        name = $(R.id.name);
        time = $(R.id.time);

    }

    @Override
    public void setData(final SensorModel.ViewDataBean person){


        name.setText(person.getGateModel());
        time.setText("位置："+person.getPosition());

        //name.setText(person.getName());
    }
}
