package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MyFamliyAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.CustomDatePicker;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.CustomSinglePicker;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by tlol20 on 2017/6/14
 */
public class EditProFileActivity extends BaseActivity implements View.OnClickListener{
    private EasyRecyclerView recyclerView;
    private MyFamliyAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    private CustomDatePicker customDatePicker1;
    private CustomSinglePicker sexPicker;
    private CustomSinglePicker constellationPicker;
    private CustomSinglePicker jobPicker;
    private CustomSinglePicker interestDatePicker;
    private CustomSinglePicker.ResultHandler jobHandler=new CustomSinglePicker.ResultHandler() {
        @Override
        public void handle(String time) { // 回调接口，获得选中的时间
            tv_job.setText(time);
        }
    };
    private CustomSinglePicker.ResultHandler interestHandler=new CustomSinglePicker.ResultHandler() {
        @Override
        public void handle(String time) { // 回调接口，获得选中的时间
            tv_interest.setText(time);
        }
    };
    private TextView currentDate,
            tv_sex,
            tv_job,
            tv_interest,
            tv_constellation;
    private CircleImageView civ_icon;
    private EditText et_nick_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pro);
        currentDate=findViewById(R.id.tv_birthday);
        tv_sex=findViewById(R.id.tv_sex);
        tv_constellation=findViewById(R.id.tv_constellation);
        tv_job=findViewById(R.id.tv_job);
        tv_interest=findViewById(R.id.tv_interest);
        civ_icon=findViewById(R.id.civ_icon);
        et_nick_name=findViewById(R.id.et_nick_name);
        tv_constellation=findViewById(R.id.tv_constellation);
        initData();
        initDatePicker();
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.rl_birthday).setOnClickListener(this);
        findViewById(R.id.ll_commit).setOnClickListener(this);
        findViewById(R.id.rl_nick_name).setOnClickListener(this);
        findViewById(R.id.rl_sex).setOnClickListener(this);
        findViewById(R.id.rl_constellation).setOnClickListener(this);
        findViewById(R.id.rl_job).setOnClickListener(this);
        findViewById(R.id.rl_interest).setOnClickListener(this);
        findViewById(R.id.civ_icon).setOnClickListener(this);
        //getData();
    }
    UserinfoBean userinfoBean;
    private void initData() {
        if (PreferencesUtils.getBoolean(this,"isLogin",false)) {
            userinfoBean= UserLocalData.getUser(this);
            Picasso.with(this).load(userinfoBean.getUserIcon()).into(civ_icon);
            et_nick_name.setText(userinfoBean.getUserName());
            tv_sex.setText(userinfoBean.getUserSex());
            currentDate.setText(userinfoBean.getUserBirthday());
            tv_constellation.setText(userinfoBean.getUserConstellation());
            tv_job.setText(userinfoBean.getUserJob());
            tv_interest.setText(userinfoBean.getUserFavourite());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_nick_name:{

            }break;
            case R.id.civ_icon:{

            }break;
            case R.id.rl_sex:{
                sexPicker.show("女");
            }break;
            case R.id.rl_birthday:{
                // 日期格式为yyyy-MM-dd
                customDatePicker1.show(currentDate.getText().toString());
            }break;
            case R.id.rl_constellation:{
                constellationPicker.show("白羊座");
            }break;
            case R.id.rl_job:{
                jobPicker.show("其他");
            }break;
            case R.id.rl_interest:{
                interestDatePicker.show("篮球");
            }break;
        }
    }

    /*private void getData() {
        Map<String,Object> params = new HashMap<>(2);
        params.put("page",1);
        params.put("rows",20);
        ok.post(Contants.API.SCAN_LIST, params, new SimpleCallback<Scan>(this) {
            @Override
            public void onSuccess(okhttp3.Response response, Scan o) {
                if (o.getMsg().getCode()==0) {
                    adapter.addAll(o.getRowSet());
                }
            }

            @Override
            public void onError(okhttp3.Response response, int code, Exception e) {

            }
        });
    }*/

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());

        Log.e("initDatePicker","SimpleDateFormat="+now);
        currentDate.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                currentDate.setText(time.split(" ")[0]);
            }
        }, "1970-01-01 00:00", now,"请选择生日"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动


        ArrayList<String> sexList=new ArrayList<>();
        sexList.add("女");
        sexList.add("男");
        sexPicker = new CustomSinglePicker(this, new CustomSinglePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tv_sex.setText(time);
            }
        },sexList,"选择性别"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        sexPicker.setIsLoop(false); // 允许循环滚动

        ArrayList<String> constellationList=new ArrayList<>();
        constellationList.add("白羊座");
        constellationList.add("金牛座");
        constellationList.add("双子座");
        constellationList.add("巨蟹座");
        constellationList.add("狮子座");
        constellationList.add("处女座");
        constellationList.add("天秤座");
        constellationList.add("天蝎座");
        constellationList.add("射手座");
        constellationList.add("瓜皮玉");
        constellationList.add("水瓶座");
        constellationList.add("双鱼座");
        constellationPicker = new CustomSinglePicker(this, new CustomSinglePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tv_constellation.setText(time);
            }
        },constellationList,"选择星座"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        constellationPicker.setIsLoop(false); // 允许循环滚动

        ArrayList<String> jobList=new ArrayList<>();
        jobList.add("学生");
        jobList.add("老师");
        jobList.add("工人");
        jobList.add("医生");
        jobList.add("导游");
        jobList.add("律师");
        jobList.add("工程师");
        jobList.add("建筑师");
        jobList.add("会计师");
        jobList.add("营养师");
        jobList.add("演员");
        jobList.add("歌手");
        jobList.add("其他");
        jobPicker = new CustomSinglePicker(this, jobHandler,jobList,"选择职业"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        jobPicker.setIsLoop(false); // 允许循环滚动

        ArrayList<String> interestList=new ArrayList<>();
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("篮球");
        interestList.add("英雄联盟");
        interestDatePicker = new CustomSinglePicker(this, interestHandler,interestList,"选择兴趣"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        interestDatePicker.setIsLoop(false); // 允许循环滚动

    }
}
