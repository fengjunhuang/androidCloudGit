package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

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
    TextView cellName;
    public HouseDetilViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_room_detil);

        iv_cell_image= $ (R.id.iv_cell_image);
       cellCost= $ (R.id.tv_cell_cost);
        cellRemain= $ (R.id.tv_cell_remain);
     cellBuildingSet= $ (R.id.tv_cell_building_set);
        cellName= $ (R.id.tv_cell_name);
    }

    @Override
    public void setData(BudingInfo.ViewDataBean.DataBean data) {
        super.setData(data);

//        cellName.setText(viewDataBean.getCellName());
//        cellRemain.setText("已经验证.剩"+viewDataBean.getCellRemain()+"间");
//        cellCost.setText("$"+viewDataBean.getCellCost());
        cellCost.setText(data.getRoomMoney());
        cellRemain.setText(data.getRoomNumber());
        cellName.setText(data.getRoomSet());
        Picasso.with(getContext()).load(data.getRoomSimpleImage()).into(iv_cell_image);

        
    }



}
