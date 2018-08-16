package com.cloudtenant.yunmenkeji.cloudtenant.viewholder;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;


/**
 * Created by Mr.Jude on 2015/2/22
 */
public class EmptyViewHolder extends BaseViewHolder<Object> {
    private TextView tv_cell_name;
    private TextView tv_cell_remain;
    private TextView tv_cell_building_set;
    private TextView tv_cell_cost;
    private ImageView imageView;

    public EmptyViewHolder(ViewGroup parent) {
        super(parent, R.layout.activity_empty);

    }

    @Override
    public void setData(final Object person){

    }
}
