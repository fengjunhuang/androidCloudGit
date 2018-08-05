package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ImageText;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by 72984 on 2018/7/3.
 */

public class TextViewHolder extends BaseViewHolder<ImageText> {
private TextView tv_text;

    private ImageView iv_icon;
    public TextViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_pow_room);
        tv_text= $(R.id.tv_text);
        iv_icon=$(R.id.iv_icon);

    }

    @Override
    public void setData(ImageText data) {

        if(data.isSelect()){
            iv_icon.setVisibility(itemView.VISIBLE);
        }else {
            iv_icon.setVisibility(itemView.INVISIBLE);
        }
        tv_text.setText(data.getText());

    }
}
