package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.R;


public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_recyclerview,container,false);

        return view;
    }

    @Override
    public void init() {

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.down: {
                if (flag){
                    fenlei.setVisibility(View.GONE);
                    gridView.setVisibility(View.GONE);
                    flag=false;
                }else {
                    fenlei.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.VISIBLE);
                    flag=true;
                }
            }break;*/

        }
    }
}
