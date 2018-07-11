package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BuildingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.gersion.library.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ContractDetailsActivity extends BaseActivity {

    private TextView details,title;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_details);
        button=findViewById(R.id.button);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.ctv_terms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckedTextView checkedTextView= ((CheckedTextView) v);
                checkedTextView.toggle();

                button.setEnabled(checkedTextView.isChecked());

            }
        });

        details=findViewById(R.id.details);
        title=findViewById(R.id.title);
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ContractDetailsActivity.this, TestNoticeActivity.class);
                intent.putExtra("aa",aa);
                startActivity(intent);
            }
        });
        getData();
    }
    String aa;
    SpannableString msp = null;
    private void getData() {

        HttpMethods.getInstance().BudingInfo(new BaseObserver<BudingInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                BudingInfo houseDetil= (BudingInfo) t;
                //details.setText(model.);

                //details.setText(houseDetil.getContract().replace("/n", "\n"));
                //Log.e("onSuccees",houseDetil.getViewData());
                aa=houseDetil.getContract().replace("/n", "\n");
                Log.e("onSuccees",aa);
                String a="%@";
                ArrayList<Integer> list=new ArrayList<>();
                ArrayList<Integer> indexList=new ArrayList<>();
                ArrayList<Integer> indexSizeList=new ArrayList<>();
                /*int index=0;
                for (int i=0;aa.indexOf(a,index)!=-1;i++){
                    list.add(aa.indexOf(a,index));
                    index=aa.indexOf(a,index)+1;
                }
                    Log.e("onSuccees","aaIndexOf长度="+list.size());
                for (Integer integer : list) {
                    Log.e("onSuccees","aaIndexOf="+integer);
                }*/
                List<String> ctList=new ArrayList<>();
                ctList.add("明珠公寓301");
                ctList.add("30");
                ctList.add("12");
                ctList.add("2018-07-10");
                ctList.add("2019-07-10");
                ctList.add("1000");
                ctList.add("壹仟");
                ctList.add("1000");
                ctList.add("2019-07-10");
                ctList.add("1000");
                ctList.add("2020-07-10");
                ctList.add("1050");
                ctList.add("12");

                int ctIndex=0;
                for (String s : ctList) {
                    aa=aa.replaceFirst(a,s);
                    indexList.add(aa.indexOf(s,ctIndex));
                    ctIndex=aa.indexOf(s,ctIndex);
                    indexSizeList.add(s.length());
                }
                msp = new SpannableString(aa);
                //设置下划线
                msp.setSpan(new UnderlineSpan(), 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                for (int i = 0; i < indexSizeList.size(); i++) {

                msp.setSpan(new UnderlineSpan(), indexList.get(i),indexList.get(i)+indexSizeList.get(i), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
                //msp.setSpan(new ScaleXSpan(2.0f), 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变

                msp.setSpan(new AbsoluteSizeSpan(80), 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                details.setText(msp);

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }
}
