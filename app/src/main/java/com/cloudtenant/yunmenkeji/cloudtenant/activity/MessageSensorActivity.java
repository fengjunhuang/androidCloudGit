package com.cloudtenant.yunmenkeji.cloudtenant.activity;



import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.FragmentAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ListRiskAreaListsDemoAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageRoomAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.FireFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.MessageOtherFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.MessagePayFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.MessageRoomFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.PersonFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.RoomMessageFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.fragment.SmokeFragment;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.OnItemClickLitener;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.view.Solve7PopupWindow;
import com.gersion.library.base.BaseActivity;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageSensorActivity extends FragmentActivity {



    private String[] mTabTitles = new String[]{"人体","火焰","烟雾"};
    public ViewPager viewPager;

    private List<String> list=new ArrayList<>();
    public PersonFragment messageRoomFragment=new PersonFragment();
    public FireFragment fireFragment=new FireFragment();
    public SmokeFragment smokeFragment=new SmokeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_sensor);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);
        Intent intent=getIntent();
        TextView t_name = findViewById(R.id.t_name);
        TextView b_name = findViewById(R.id.b_name);
        t_name.setText(intent.getStringExtra("t_name"));
        b_name.setText(intent.getStringExtra("b_name"));
        messageRoomFragment.roomId=intent.getStringExtra("roomId");
        fireFragment.roomId=intent.getStringExtra("roomId");
        smokeFragment.roomId=intent.getStringExtra("roomId");
        messageRoomFragment.sensorModel=intent.getStringExtra("b_name");
        fireFragment.sensorModel=intent.getStringExtra("b_name");
        smokeFragment.sensorModel=intent.getStringExtra("b_name");

        Fragment[] fragments ={messageRoomFragment
                ,fireFragment,smokeFragment};

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments, mTabTitles));
        viewPager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("onPageSelected","position="+position);
                switch (position){
                    case 0:{
                    }break;
                    case 1:{
                    }break;
                    case 2:{
                    }break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }




}
