package com.cloudtenant.yunmenkeji.cloudtenant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Tab;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.HomeFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.MeFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;
    public FragmentTabHost mTabhost;
    private List<Tab> mTabs = new ArrayList<>(4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化
        initTab();
    }

    private void initTab() {
        Tab tab_share = new Tab(HomeFragment.class,R.string.house,R.drawable.selector_icon_house);
        Tab tab_route = new Tab(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        Tab tab_more = new Tab(HomeFragment.class,R.string.message,R.drawable.selector_icon_message);
        Tab tab_mine = new Tab(MeFragment.class,R.string.mine,R.drawable.selector_icon_me);

        mTabs.add(tab_share);
        mTabs.add(tab_route);
        mTabs.add(tab_more);
        mTabs.add(tab_mine);

        mInflater = LayoutInflater.from(this);
        mTabhost= (FragmentTabHost) findViewById(R.id.my);

        mTabhost.setup(this, getSupportFragmentManager(),R.id.fl);

        for (Tab tab : mTabs){

            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabhost.addTab(tabSpec,tab.getFragment(),null);

        }

        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);


    }

    private View buildIndicator(Tab tab){


        View view =mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return  view;
    }
}
