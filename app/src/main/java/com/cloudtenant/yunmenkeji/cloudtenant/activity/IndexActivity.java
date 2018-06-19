package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;


import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseHomeActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.HomeFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.MeFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.RoomFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.view.CustomViewPager;
import com.flyco.tablayout.widget.MsgView;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseFragment;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


/**
 * Author: 姚智胜
 * Version: V1.0版本
 * Description:  首页
 * Date: 2016/12/15.
 */
@EActivity
public class IndexActivity extends YzsBaseHomeActivity {


    private static final String TAG = "IndexActivity";

    private String[] mTitles = {"入住", "房间", "消息","我的"};
    @ViewById(R.id.yzs_base_tabLayout_viewPager)
    CustomViewPager customViewPager;
    private int[] mIconUnselectIds = {R.mipmap.home,
            R.mipmap.mehome, R.mipmap.message,
            R.mipmap.me};
    private int[] mIconSelectIds = {
            R.mipmap.home_select,R.mipmap.myhome_select, R.mipmap.message_select,
            R.mipmap.me_select};

    @Override
    protected void initContentView(Bundle bundle) {
        setContentView(R.layout.activity_index);
    }

    @Override
    protected void onTabSelect(int i) {
        mTabLayout.hideMsg(i);
        switch (i){
            case 0:


                break;
            case 1:


                break;
            case  2:

                break;


        }


    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //Toolbar 必须在onCreate()之后设置标题文本，否则默认标签将覆盖我们的设置
        if (getmToolbar() != null) {//mActionBarToolbar就是android.support.v7.widget.Toolbar
            getmToolbar().setTitle("");//设置为空，可以自己定义一个居中的控件，当做标题控件使用
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        for (Fragment fragment : mFragments) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }

    }
    @Override
    protected void onTabReselect(int i) {
        mTabLayout.hideMsg(i);
    }

    @Override
    protected void initTab() {
        setmFragments(new YzsBaseFragment[]{new HomeFragment(),new RoomFragment(),new HomeFragment(), new MeFragment()});
        setmIconSelectIds(mIconSelectIds);
        setmIconUnSelectIds(mIconUnselectIds);
        setmTitles(mTitles);







    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }


    @Override
    protected void initLogic() {
        //一句话调用loading

/*        showLoadingDialog(MLoadingDialog.YZS_LOADING, R.mipmap.icon);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //取消loading
                cancelLoadingDialog();
            }
        }, 3000);*/

        //        除了初始化方法，其他情况下改变选中position使用该方法
//        mTabLayout.setCurrentTab(1);

        //设置未读消息红点
        mTabLayout.showDot(1);
        //设置未读消息背景故障上报
        mTabLayout.showMsg(0, 5);
        //设置自定义颜色的msg
        mTabLayout.setMsgMargin(3, 0, 5);
        MsgView rtv_2_3 = mTabLayout.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }




    }

    @Override
    protected void getBundleExtras(Bundle extras) {
     if(extras!=null){






     }
    }

    @Override
    protected void onEventComing(EventCenter center) {




    }


}
