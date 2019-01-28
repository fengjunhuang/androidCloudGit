package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class MyFamilyViewHolder extends BaseViewHolder<MyFamily.ViewDataBean> {
    private TextView name;
    private TextView fans;
    private TextView note;
    private TextView time;
    private CircleImageView icon;

    public MyFamilyViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_my_family);
        name = $(R.id.name);

    }

    @Override
    public void setData(final MyFamily.ViewDataBean person){
        name.setText(person.getRoomName());

        //name.setText(person.getName());
    }
}
