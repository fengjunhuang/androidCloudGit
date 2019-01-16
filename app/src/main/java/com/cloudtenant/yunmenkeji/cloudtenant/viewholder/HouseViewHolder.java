package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AppUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
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
    private TextView tv_cell_juli;
    private ImageView imageView;

    public HouseViewHolder(ViewGroup parent) {
        super(parent, R.layout.activity_awt);
        tv_cell_name = $(R.id.tv_cell_name);
        tv_cell_cost = $(R.id.tv_cell_cost);
        tv_cell_remain = $(R.id.tv_cell_remain);
        tv_cell_juli = $(R.id.tv_cell_juli);
        tv_cell_building_set = $(R.id.tv_cell_building_set);
        imageView = $(R.id.iv);

    }

    @Override
    public void setData(final HouseDetil.ViewDataBean person){
        tv_cell_name.setText(person.getCellName());
        tv_cell_remain.setText("云门验证·剩" + person.getCellRemain() + "间");
        tv_cell_building_set.setText(person.getSynopsis());
        SpannableString msp = new SpannableString("￥" + person.getCellCost() + "/月");
        int size=person.getCellCost().length()+1;
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        tv_cell_cost.setText(msp);
        tv_cell_name.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        String image= HttpMethods.BASE_URL+person.getCellImage();
        //Picasso.with(getContext()).load(person.getCellImage()).fit().into(imageView);
        Picasso.with(getContext()).load(image).fit().into(imageView);
        double long1=Double.parseDouble(person.getCellLongitude());
        double lat1=Double.parseDouble(person.getCellLatitude());
        double long2=Double.parseDouble(PreferencesUtils.getString(getContext(),"longitude","116.46"));
        double lat2=Double.parseDouble(PreferencesUtils.getString(getContext(),"latitude","39.92"));
        Log.d("setData","房子坐标="+long1+","+lat1+".>>定位坐标="+long2+","+lat2);
        double juli=AppUtils.Distance(lat1,long1, long2,lat2);
        DecimalFormat df2 = new DecimalFormat("###.0");
        tv_cell_juli.setText(df2.format(juli)+"km");
        /*if (!PreferencesUtils.getBoolean(getContext(),"isShow")){
            tv_cell_name.setVisibility(View.GONE);
            tv_cell_cost.setVisibility(View.GONE);
            tv_cell_building_set.setVisibility(View.GONE);
            tv_cell_remain.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
        }else {

        }*/
    }



}
