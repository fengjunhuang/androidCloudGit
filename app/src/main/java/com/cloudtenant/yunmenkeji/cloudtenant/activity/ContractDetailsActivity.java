package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.TnementBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.ChineseNumber;
import com.gersion.library.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ContractDetailsActivity extends BaseActivity {

    private TextView details,title;
    private Button button;
    private TnementBean bean;
    //private HouseDetil.ViewDataBean houseDetil;
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
                Intent intent=new Intent(ContractDetailsActivity.this, CommitIdActivity.class);
                intent.putExtra("buildingID",bean.getCellBuildID());
                intent.putExtra("roomId",bean.getRoomID());
                intent.putExtra("roomNum",bean.getRoomNumber());
                intent.putExtra("contractTime",contractTime);
                startActivity(intent);
            }
        });
        getData();
    }
    String aa;
    SpannableString msp = null;
    String roomMoney,contractTime;
    ChineseNumber chineseNumber=new ChineseNumber();
    private void getData() {
        //houseDetil = ( HouseDetil.ViewDataBean) getIntent().getExtras().getSerializable("houseDetil");
         bean = (TnementBean) getIntent().getExtras().getSerializable("bean");
         roomMoney=getIntent().getStringExtra("roomMoney");
         String time=getIntent().getStringExtra("time");
         int setTime=3;
         switch (time){
             case "三个月":{
                //setTime="3";
                 contractTime="三个月";
             }break;
             case "半年":{
                 contractTime="半年";
                setTime=6;
             }break;
             case "一年":{
                 contractTime="一年";
                setTime=12;
             }break;
         }
        aa=bean.getContract().replace("/n", "\n");
        Log.e("onSuccees",aa);
        String a="%@";

        ArrayList<Integer> indexList=new ArrayList<>();
        ArrayList<Integer> indexSizeList=new ArrayList<>();

        List<String> ctList=new ArrayList<>();
        //cellAddress
        ctList.add(bean.getCellName()+bean.getRoomNumber());
        //roomSquare
        ctList.add(bean.getRoomSquare());
        //固定
        ctList.add(setTime+"");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        //当前日期
        ctList.add(now);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        //System.out.println("111111111::::"+cal.getTime());
        cal.add(Calendar.MONTH, setTime);//增加一年
        String nowPlus=sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, 12-setTime);//增加一年
        String nowPlus1=sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, 24-setTime);//增加一年
        String nowPlus2=sdf.format(cal.getTime());
        //当前日期加一年
        ctList.add(nowPlus);
        //roomMoney
        ctList.add(roomMoney);
        Log.d("ContractDetailsActivity","roomMoney="+roomMoney);
        //roomMoney大写
        ctList.add(chineseNumber.getCnString(roomMoney).substring(0).replace("元",""));
        //roomMoney
        ctList.add(roomMoney);
        //固定涨价
        ctList.add("300");
        //当前日期
        ctList.add(now);
        //roomMoney
        ctList.add(roomMoney);
        //当前日期加一年
        ctList.add(nowPlus1);
        //当前日期加2年
        ctList.add(nowPlus2);
        //roomMoney+50
        Float price=Float.parseFloat(roomMoney)+300;
        ctList.add(price+"");
        //固定
        ctList.add(setTime+"");

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
        //设置字体大小（相对值,单位：像素） 参数表示为多少像素
        //msp.setSpan(new AbsoluteSizeSpan(80), 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        details.setText(msp);
       /* HttpMethods.getInstance().BudingInfo(new BaseObserver<BudingInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                BudingInfo budingInfo= (BudingInfo) t;
                //details.setText(model.);

                //details.setText(houseDetil.getContract().replace("/n", "\n"));
                //Log.e("onSuccees",houseDetil.getViewData());


            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");*/
    }
}
