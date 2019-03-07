package com.cloudtenant.yunmenkeji.cloudtenant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by tlol20 on 2017/6/2
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;
    private String[] mTabTitles = new String[]{};
    public FragmentAdapter(FragmentManager fm, Fragment[] fragments, String[] mTabTitles) {
        super(fm);
        this.fragments=fragments;
        this.mTabTitles=mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTabTitles != null) {
            return mTabTitles[position];
        }
        return super.getPageTitle(position);
    }
}
