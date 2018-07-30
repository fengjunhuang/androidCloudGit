package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class HouseDetilViewHolder extends BaseViewHolder<BudingInfo.ViewDataBean.DataBean> {
    ImageView iv_cell_image;
    TextView cellCost;
    TextView cellRemain;
    TextView cellBuildingSet;
    TextView tv_seeTimes;

    public HouseDetilViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_room_detil);

        iv_cell_image= $ (R.id.iv_cell_image);
        cellCost= $ (R.id.tv_cell_cost);
        cellRemain= $ (R.id.tv_cell_remain);
        cellBuildingSet= $ (R.id.tv_cell_building_set);
        tv_seeTimes=$(R.id.tv_seeTimes);
    }

    @Override
    public void setData(BudingInfo.ViewDataBean.DataBean data) {
        super.setData(data);
        SpannableString msp = new SpannableString("￥" + data.getRoomMoney() + "/月");
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        cellCost.setText(msp);
        cellRemain.setText(data.getRoomNumber());
        tv_seeTimes.setText(data.getRoomReviewTimes()+"次");
        Picasso.with(getContext()).load(data.getRoomSimpleImage()).fit().into(iv_cell_image);

    }

}
