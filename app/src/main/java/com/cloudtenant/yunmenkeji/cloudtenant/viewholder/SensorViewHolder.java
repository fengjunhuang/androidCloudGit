package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Sensor;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class SensorViewHolder extends BaseViewHolder<Sensor> {
    private TextView name;
    private TextView fans;
    private TextView note;
    private TextView time;
    private CircleImageView icon;

    public SensorViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_sensor);
        time = $(R.id.time);

    }

    @Override
    public void setData(final Sensor person){
        //name.setText(person.getFamily());

        //name.setText(person.getName());
    }
}
