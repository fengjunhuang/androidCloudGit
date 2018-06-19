package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.Indexdata;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BannerPicassoImageLoader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PicassoImageLoader;
import com.youth.banner.Banner;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends YzsBaseListFragment<Indexdata> implements View.OnClickListener {







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

    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
       View view=layoutInflater.inflate(R.layout.activity_recyclerview,viewGroup,false);
        List<String> images=new ArrayList<>();
        Banner banner = (Banner)view. findViewById(R.id.banner);
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529230178291&di=71e9d9b4ad4deb6d8f21e90cf4ced6ac&imgtype=0&src=http%3A%2F%2Fpic15.nipic.com%2F20110708%2F7843095_103004548386_2.jpg");
       images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529230293646&di=b367f393dc03c3c8d22d0ee923eb2f2d&imgtype=0&src=http%3A%2F%2Fpic3.16pic.com%2F00%2F04%2F28%2F16pic_428522_b.jpg");

        banner.setImages(images).setImageLoader(new BannerPicassoImageLoader()).start();


        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initItemLayout() {
        setLayoutResId(R.layout.item_house_detil);
        setListType(LINEAR_LAYOUT_MANAGER, true);
    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, Indexdata indexdata) {

    }



    @Override
    protected void initLogic() {
        Indexdata indexdata1 =new Indexdata();
        Indexdata indexdata2 =new Indexdata();
        Indexdata indexdata3=new Indexdata();
        List<Indexdata> lists=new ArrayList<>();
        lists.add(indexdata1);
        lists.add(indexdata2);
        lists.add(indexdata3);
        mAdapter.addData(lists);
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
