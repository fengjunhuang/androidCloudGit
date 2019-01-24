package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyCollection;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class MyCollectionViewHolder extends BaseViewHolder<MyCollection.ViewDataBean> {
    private TextView nmsl;
    private TextView nimasile;
    private TextView tv_cell_building_set;
    private TextView tv_cell_cost;
    private ImageView iv_cell_image;

    public MyCollectionViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_my_collection);
        tv_cell_building_set = $(R.id.tv_cell_building_set);
        nimasile = $(R.id.nimasile);
        tv_cell_cost = $(R.id.tv_cell_cost);
        nmsl = $(R.id.nmsl);
        iv_cell_image = $(R.id.iv_cell_image);

    }

    @Override
    public void setData( MyCollection.ViewDataBean person){
        nmsl.setText(person.getBuildingName());
        nimasile.setText(person.getRoomNum()+"");
        String r="";
        switch (person.getRoomStyleType()){
            case "0":{
                r="单间";
            }break;case "1":{
                r="一房一厅";
            }break;case "2":{
                r="二房一厅";
            }break;case "3":{
                r="三房一厅";
            }break;case "4":{
                r="复试";
            }break;case "5":{
                r="未知";
            }break;
            default:break;
        }
        SpannableString msp = new SpannableString("￥" + person.getRoomMonthly() + "/月");
        String s=person.getRoomMonthly()+"";
        int size=s.length()+1;
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        tv_cell_cost.setText(msp);
        tv_cell_building_set.setText(person.getRoomMarginType()+" | "+r);
        Picasso.with(getContext()).load(HttpMethods.BASE_URL +person.getRoomImage()).fit().into(iv_cell_image);
        //name.setText(person.getName());
    }
}
