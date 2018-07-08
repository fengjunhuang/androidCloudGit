package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.squareup.picasso.Picasso;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 72984 on 2018/6/24.
 */
@EActivity
public class TnementAcitivity extends YzsBaseActivity {
    @ViewById(R.id.iv_cell_image)
    ImageView iv_cell;
    @ViewById(R.id.tv_cell_remain)
    TextView tv_cell_remain;
    @ViewById(R.id.tv_cell_cost)
    TextView tv_cell_cost;
    @ViewById(R.id.tv_kongtiao)
    TextView tv_kongtiao;
    @ViewById(R.id.tv_chuang)
    TextView tv_chuang;
    @ViewById(R.id.tv_reshuiqi)
    TextView tv_reshuiqi;
    @ViewById(R.id.tv_xiyiji)
    TextView tv_xiyiji;
    @ViewById(R.id.tv_dianshiji)
    TextView tv_dianshiji;
    @ViewById(R.id.tv_yigui)
    TextView tv_yigui;
    @ViewById(R.id.tv_shafa)
    TextView tv_shafa;
    @ViewById(R.id.tv_huangdai)
    TextView tv_huangdai;
    @ViewById(R.id.tv_tianranqi)
    TextView tv_tianranqi;
    @ViewById(R.id.tv_bingxiang)
    TextView tv_bingxiang;
    @ViewById(R.id.tv_style)
    TextView tv_style;
    @Click(R.id.iv_cell_image)

   void onClick(){
      Bundle bundle =new Bundle();
      bundle.putSerializable("bean",bean);
       readyGo(OnlineVisitAcivity.class,bundle);
    }
    private List<TextView> ss =new ArrayList<>();
    BudingInfo.ViewDataBean.DataBean bean;
    @Override
    protected void initContentView(Bundle var1) {
       setContentView(R.layout.activity_tnement);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {
        ss.add(tv_bingxiang);
        ss.add(tv_dianshiji);
        ss.add(tv_chuang);
        ss.add(tv_kongtiao);
        ss.add(tv_huangdai);
        ss.add(tv_reshuiqi);
        ss.add(tv_xiyiji);
        ss.add(tv_tianranqi);
        ss.add(tv_dianshiji);
        setSmellText("组这间？");
       getBundleExtras(getIntent().getExtras());
        getBtn1().setVisibility(View.INVISIBLE);
        getBtn2().setVisibility(View.INVISIBLE);
        getTv_out().setVisibility(View.VISIBLE);


    }

    @Override
    protected void getBundleExtras(Bundle var1) {
        bean = (BudingInfo.ViewDataBean.DataBean) var1.getSerializable("bean");
        Picasso.with(this).load(bean.getRoomSimpleImage()).fit().into(iv_cell);
        tv_cell_remain.setText(bean.getRoomNumber());
        tv_cell_cost.setText(bean.getRoomMoney());
        tv_style.setText(bean.getRoomStyle());
        getTv_smell().setTextColor(Color.BLACK);
      String[] s=  bean.getRoomSet().split(" ");
     for(int i=0;i<s.length;i++){
            String str=s[i];
       for(TextView textView :ss){

           if(textView.getText().equals(str)){
               textView.setTextColor(Color.parseColor("#0DADA2"));


           }

       }
         }


     }



    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
