package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;


public class MeFragment extends BaseFragment implements View.OnClickListener {


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
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

    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view=layoutInflater.inflate(R.layout.activity_me,viewGroup,false);
        TextView userName=view.findViewById(R.id.userName);
        userName.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        final View me_topbar=view.findViewById(R.id.me_topbar);

        ScrollView mScrollView=view.findViewById(R.id.myscrollview);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    Log.e("MeFrangment","i="+i+">>i1="+i1+">>i2="+i2+">>i3"+i3);
                    if (i1<150){
                        float alpha=i1/150;

                        Log.e("MeFrangment","alpha="+alpha);
                        if (i1<128){

                            if (me_topbar!=null){
                                me_topbar.setAlpha(0);
                            }
                        }else {
                            //me_topbar.getBackground().setAlpha(255);
                            me_topbar.setAlpha(1);

                        }
                    }
                }
            });
        }
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
