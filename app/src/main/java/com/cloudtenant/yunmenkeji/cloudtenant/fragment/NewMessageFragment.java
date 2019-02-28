package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.FragmentAdapter;


public class NewMessageFragment extends Fragment {

    private String[] mTabTitles = new String[]{"楼宇公告","其他消息","支付消息","房间消息"};
    public ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_message_one,container,false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        Fragment[] fragments = new Fragment[0];
            /*    ={new CharmCharmFragment()
                ,new CharmDayFragment(),new CharmWeekFragment ()};*/
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments, mTabTitles));
        viewPager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }



}
