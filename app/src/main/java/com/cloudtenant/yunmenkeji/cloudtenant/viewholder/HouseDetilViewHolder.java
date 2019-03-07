package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class HouseDetilViewHolder extends BaseViewHolder<BudingInfo.ViewDataBean.DataBean> {
    ImageView iv_cell_image;
    ImageView is_sc;
    TextView cellCost;
    TextView cellRemain;
    TextView cellBuildingSet;
    TextView tv_seeTimes;
    TextView tv_style;

    public HouseDetilViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_room_detil);

        iv_cell_image= $ (R.id.iv_cell_image);
        is_sc= $ (R.id.is_sc);
        tv_style= $ (R.id.tv_style);
        cellCost= $ (R.id.tv_cell_cost);
        cellRemain= $ (R.id.tv_cell_remain);
        cellBuildingSet= $ (R.id.tv_cell_building_set);
        tv_seeTimes=$(R.id.tv_seeTimes);
    }

    @Override
    public void setData(BudingInfo.ViewDataBean.DataBean data) {
        super.setData(data);
        Log.d("HouseDetilViewHolder",data.toString());
        SpannableString msp = new SpannableString("￥" + data.getRoomMoney() + "/月");
        int size=data.getRoomMoney().length()+1;
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        cellCost.setText(msp);
        cellRemain.setText(data.getRoomNumber());
        tv_seeTimes.setText(data.getRoomReadNum());
        Picasso.with(getContext()).load(HttpMethods.BASE_URL +data.getRoomSimpleImage()).fit().into(iv_cell_image);
        String l="";
        switch (data.getRoomMarginType()){
            case 0:{
                l="一按一租";
            }break;case 1:{
                l="两按一租";
            }break;case 2:{
                l="三按一租";
            }break;
            default:break;
        }
        String r="";
        switch (data.getRoomStyle()){
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
        tv_style.setText(l+" | "+r);
        Log.d("HouseDetilViewHolder","isCollection="+data.getIsCollection());
        if (data.getIsCollection().equals("false")) {
            is_sc.setImageResource(R.drawable.sc);
        }else {
            is_sc.setImageResource(R.drawable.shoucang);
        }
    }

}
