package com.cloudtenant.yunmenkeji.cloudtenant.base;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.yzs.yzsbaseactivitylib.R.id;
import com.yzs.yzsbaseactivitylib.entity.TabEntity;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseFragment;

import java.util.ArrayList;

public abstract class YzsBaseHomeActivity extends YzsBaseActivity {
    private static final String TAG = "YzsBaseHomeActivity";
    private String[] mTitles;
    private int[] mIconUnSelectIds;
    private int[] mIconSelectIds;
    protected YzsBaseFragment[] mFragments;
    protected CommonTabLayout mTabLayout;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList();
    protected ViewPager mViewPager;
    protected FrameLayout mFrameLayout;
    private Bundle bundle;
    private int initChooseTab;
    private boolean isFirst = true;

    public YzsBaseHomeActivity() {
    }

    public void setInitChooseTab(int initChooseTab) {
        this.initChooseTab = initChooseTab;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setBundle(savedInstanceState);
    }


    protected void initView() {
        this.mTabLayout = (CommonTabLayout)this.findViewById(id.yzs_base_tabLayout);
        this.mViewPager = (ViewPager)this.findViewById(id.yzs_base_tabLayout_viewPager);
        this.mFrameLayout = (FrameLayout)this.findViewById(id.yzs_base_tabLayout_frameLayout);
        this.initTab();
        mTabLayout.setTextSelectColor(Color.RED);
        if(null != this.mFragments && this.mFragments.length != 0) {
            this.initTabEntities();
            if(null == this.mTabLayout) {
                throw new RuntimeException("CommonTabLayout is null!");
            } else {
                if(null == this.mTitles || this.mTitles.length == 0) {
                    this.mTabLayout.setTextsize(0.0F);
                }

                if(null != this.mViewPager) {
                    Log.e("YzsBaseHomeActivity", "Choose_ViewPager");
                    this.initViewpagerAdapter();
                } else {
                    this.initFragments();
                    Log.e("YzsBaseHomeActivity", "Choose_frameLayout");
                }

                this.setTabSelect();
                if(null != this.mViewPager) {
                    this.mViewPager.setCurrentItem(this.initChooseTab);
                } else {
                    this.mTabLayout.setCurrentTab(this.initChooseTab);
                }

            }
        } else {
            throw new RuntimeException("mFragments is null!");
        }
    }

    private void initTabEntities() {
        if(null != this.mFragments && this.mFragments.length != 0 && this.mFragments.length == this.mIconSelectIds.length && this.mFragments.length == this.mIconUnSelectIds.length) {
            for(int i = 0; i < this.mFragments.length; ++i) {
                this.mTabEntities.add(new TabEntity(this.mTitles == null?"":this.mTitles[i], this.mIconSelectIds[i], this.mIconUnSelectIds[i]));
            }

            this.mTabLayout.setTabData(this.mTabEntities);
        } else {
            throw new RuntimeException("mFragments is null!or Fragments and the number of ICONS do not meet");
        }
    }

    private void initFragments() {
        if(this.getBundle() == null) {
            this.loadMultipleRootFragment(id.yzs_base_tabLayout_frameLayout, this.initChooseTab, this.mFragments);
        } else {
            for(int i = 0; i < this.mFragments.length; ++i) {
                Log.e("YzsBaseHomeActivity", "initFragments" + i);
                this.mFragments[i] = (YzsBaseFragment)this.findFragment(this.mFragments[i].getClass());
            }
        }

    }


    private void initViewpagerAdapter() {
        this.mViewPager.setAdapter(new YzsBaseHomeActivity.MyPagerAdapter(this.getSupportFragmentManager()));
        this.mViewPager.setOffscreenPageLimit(this.mFragments.length - 1);
        this.mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                YzsBaseHomeActivity.this.mTabLayout.setCurrentTab(position);
            }

            public void onPageScrollStateChanged(int state) {
                if(state == 0) {
                    YzsBaseHomeActivity.this.onTabSelect(YzsBaseHomeActivity.this.mViewPager.getCurrentItem());
                }

            }
        });
    }

    private void setTabSelect() {
        Log.e("YzsBaseHomeActivity", "setTabSelect");
        this.mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            public void onTabSelect(int position) {
                if(null != YzsBaseHomeActivity.this.mViewPager) {
                    YzsBaseHomeActivity.this.mViewPager.setCurrentItem(position);
                } else {
                    int toDoHidden = -1;

                    for(int i = 0; i < YzsBaseHomeActivity.this.mFragments.length; ++i) {
                        if(!YzsBaseHomeActivity.this.mFragments[i].isHidden()) {
                            toDoHidden = i;
                            Log.e("YzsBaseHomeActivity", "查找显示中的fragment-------" + i);
                        }
                    }

                    Log.e("YzsBaseHomeActivity", "选中的fragment-------" + position);
                    Log.e("YzsBaseHomeActivity", "确定显示中的fragment-------" + toDoHidden);
                    YzsBaseHomeActivity.this.showHideFragment(YzsBaseHomeActivity.this.mFragments[position], YzsBaseHomeActivity.this.mFragments[toDoHidden]);
                }

                YzsBaseHomeActivity.this.onTabSelect(position);
            }

            public void onTabReselect(int position) {
                Log.e("YzsBaseHomeActivity", "再次选中项" + position);
                YzsBaseHomeActivity.this.onTabReselect(position);
            }
        });
    }

    protected abstract void onTabSelect(int var1);

    protected abstract void onTabReselect(int var1);

    protected abstract void initTab();

    public YzsBaseFragment[] getmFragments() {
        return this.mFragments;
    }

    public void setmFragments(YzsBaseFragment[] mFragments) {
        this.mFragments = mFragments;
    }

    public int[] getmIconSelectIds() {
        return this.mIconSelectIds;
    }

    public void setmIconSelectIds(int[] mIconSelectIds) {
        this.mIconSelectIds = mIconSelectIds;
    }

    public int[] getmIconUnSelectIds() {
        return this.mIconUnSelectIds;
    }

    public void setmIconUnSelectIds(int[] mIconUnSelectIds) {
        this.mIconUnSelectIds = mIconUnSelectIds;
    }

    public String[] getmTitles() {
        return this.mTitles;
    }

    public void setmTitles(String[] mTitles) {
        this.mTitles = mTitles;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getCount() {
            return YzsBaseHomeActivity.this.mFragments.length;
        }

        public CharSequence getPageTitle(int position) {
            return YzsBaseHomeActivity.this.mTitles == null?"":YzsBaseHomeActivity.this.mTitles[position];
        }

        public Fragment getItem(int position) {
            return YzsBaseHomeActivity.this.mFragments[position];
        }
    }

}
