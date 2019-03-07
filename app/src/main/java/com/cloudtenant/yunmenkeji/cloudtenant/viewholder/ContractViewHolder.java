package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class ContractViewHolder extends BaseViewHolder<MyContract.ViewDataBean> {
    private TextView name;
    private TextView stute_confirm;
    private TextView stute_ing;
    private TextView time;
    private CircleImageView icon;

    public ContractViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_my_contract);
        name = $(R.id.name);
        time = $(R.id.time);
        stute_confirm = $(R.id.stute_confirm);
        stute_ing = $(R.id.stute_ing);

    }

    @Override
    public void setData(final MyContract.ViewDataBean person){
        name.setText(person.getContractName());
        time.setText(person.getContractEndTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        try {
            Date bt=sdf.parse(now);
            Date et=sdf.parse(person.getContractEndTime());
            if (!bt.before(et)) {
                time.setTextColor(getContext().getResources().getColor(R.color.red_cut_clorr));
            }else {
                time.setTextColor(getContext().getResources().getColor(R.color.gren_cut_clorr));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        stute_ing.setVisibility(View.GONE);
        stute_confirm.setVisibility(View.GONE);
        if (person.getContractType().equals("1")) {
            stute_ing.setVisibility(View.VISIBLE);
        }else {
            stute_confirm.setVisibility(View.VISIBLE);
        }
        //name.setText(person.getName());
    }
}
