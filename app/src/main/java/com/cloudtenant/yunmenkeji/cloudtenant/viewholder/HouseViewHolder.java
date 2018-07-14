package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class HouseViewHolder extends BaseViewHolder<HouseDetil.ViewDataBean> {
    private TextView tv_cell_name;
    private TextView tv_cell_remain;
    private TextView tv_cell_building_set;
    private TextView tv_cell_cost;
    private ImageView imageView;

    public HouseViewHolder(ViewGroup parent) {
        super(parent, R.layout.activity_awt);
        tv_cell_name = $(R.id.tv_cell_name);
        tv_cell_cost = $(R.id.tv_cell_cost);
        tv_cell_remain = $(R.id.tv_cell_remain);
        tv_cell_building_set = $(R.id.tv_cell_building_set);
        imageView = $(R.id.iv);

    }

    @Override
    public void setData(final HouseDetil.ViewDataBean person){

        tv_cell_name.setText(person.getCellName());
        tv_cell_cost.setText(person.getCellCost());
        tv_cell_building_set.setText(person.getCellBuildingSet());
        tv_cell_remain.setText("云门验证·剩："+person.getCellRemain()+"间");

        Picasso.with(getContext()).load(person.getCellImage()).into(imageView);
       /* name.setText(person.getContractName());
        time.setText(person.getContractEndTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        try {
            Date bt=sdf.parse(now);
            Date et=sdf.parse(person.getContractEndTime());
            if (!bt.before(et)) {
                time.setTextColor(Color.RED);
            }else {
                time.setTextColor(Color.GREEN);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        stute_ing.setVisibility(View.GONE);
        stute_confirm.setVisibility(View.GONE);
        if (person.getContractType()==1) {
            stute_ing.setVisibility(View.VISIBLE);
        }else {
            stute_confirm.setVisibility(View.VISIBLE);
        }*/
        //name.setText(person.getName());
    }
}
