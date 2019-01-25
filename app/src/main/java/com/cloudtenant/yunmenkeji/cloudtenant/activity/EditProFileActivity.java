package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MyFamliyAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IconUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.CustomDatePicker;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.CustomSinglePicker;
import com.gersion.library.base.BaseActivity;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by tlol20 on 2017/6/14
 */
public class EditProFileActivity extends TakePhotoActivity implements View.OnClickListener{
    private EasyRecyclerView recyclerView;
    private LinearLayout ll_commit;
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
            userJob=time;
        }
    };
    private CustomSinglePicker.ResultHandler interestHandler=new CustomSinglePicker.ResultHandler() {
        @Override
        public void handle(String time) { // 回调接口，获得选中的时间
            tv_interest.setText(time);
            userFavourite=time;
        }
    };
    private TextView currentDate,
            tv_sex,
            tv_job,
            tv_interest,
            tv_constellation;
    private CircleImageView civ_icon;
    private EditText et_nick_name;
    private TakePhoto takePhoto;

    private CropOptions getCropOptions(){
        int height= 600;
        int width= 600;
        CropOptions.Builder builder=new CropOptions.Builder();
        builder.setOutputX(width).setOutputY(height);
        builder.setWithOwnCrop(true);
        return builder.create();
    }
    //压缩处理
    private void configCompress(TakePhoto takePhoto){
        int maxSize= 102400;
        int width= 600;
        int height= 600;
        //是否显示进度条
        boolean showProgressBar=false;
        //压缩后是否保存原图
        boolean enableRawFile = true;
        CompressConfig config;
        //使用自带相册
        config=new CompressConfig.Builder()
                .setMaxSize(maxSize)
                .setMaxPixel(width>=height? width:height)
                .enableReserveRaw(enableRawFile)
                .create();
        takePhoto.onEnableCompress(config, showProgressBar);

    }
    private void configTakePhotoOption(TakePhoto takePhoto){
        TakePhotoOptions.Builder builder=new TakePhotoOptions.Builder();
        //使用自带相册
        builder.setWithOwnGallery(false);
        takePhoto.setTakePhotoOptions(builder.create());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pro);
        currentDate=findViewById(R.id.tv_birthday);
        tv_sex=findViewById(R.id.tv_sex);
        tv_constellation=findViewById(R.id.tv_constellation);
        tv_job=findViewById(R.id.tv_job);
        ll_commit=findViewById(R.id.ll_commit);
        tv_interest=findViewById(R.id.tv_interest);
        civ_icon=findViewById(R.id.civ_icon);
        et_nick_name=findViewById(R.id.et_nick_name);
        tv_constellation=findViewById(R.id.tv_constellation);
        takePhoto=getTakePhoto();
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
    private void getUserMessage() {
        try {
            userName=new String( et_nick_name.getText().toString().trim().getBytes("GBK"),"UTF-8");
            userSex=new String( userSex.getBytes("GBK"),"UTF-8");
            userBirthday=new String( userBirthday.getBytes("GBK"),"UTF-8");
            userConstellation=new String( userConstellation.getBytes("GBK"),"UTF-8");
            userJob=new String( userJob.getBytes("GBK"),"UTF-8");
            userFavourite=new String( userFavourite.getBytes("GBK"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    UserinfoBean userinfoBean;
    private String userName,userSex,userBirthday,userConstellation,userJob,userFavourite,userPhone;
    private void initData() {

        userinfoBean= UserLocalData.getUser(this);
        assert userinfoBean != null;
        String image= "http://123.207.91.208:80/"+userinfoBean.getUserIcon();
        userPhone=userinfoBean.getUserPhone();
        userName=userinfoBean.getUserName() ;
        userSex=userinfoBean.getUserSex() ;
        userBirthday=userinfoBean.getUserBirthday() ;
        userConstellation=userinfoBean.getUserConstellation() ;
        userJob=userinfoBean.getUserJob() ;
        userFavourite=userinfoBean.getUserFavourite() ;
        if (userinfoBean.getUserIcon()!=null) {
            Picasso.with(this).load(image).into(civ_icon);
        }
        et_nick_name.setText(userName);
        tv_sex.setText(userSex);

        Log.d("initData","userBirthday="+userBirthday);
        currentDate.setText(userBirthday);
        tv_constellation.setText(userConstellation);
        tv_job.setText(userJob);
        tv_interest.setText(userFavourite);

    }
    private String frontPath;
    private String basePic;
    private String getImageToView(String filePhat) {
        String headimage = null;

        Bitmap photo = BitmapFactory.decodeFile(filePhat);

        try {
            /**
             * 下面注释的方法是将裁剪之后的图片以Base64Coder的字符方式上
             */
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] b = stream.toByteArray();
            // 将图片流以字符串形式存储下来
            headimage = Base64.encodeToString(b, Base64.DEFAULT);
            // image = new String(Base64Coder.encodeLines(b));
            //System.err.println(headimage);
            stream.close();
            // 这个地方给服务器上传图片的实现，直接把image直接上传就可以了，
            // 如果下载到的服务器的数据还是以Base64Coder的形式的话，可以用以下方式转换
            // 为我们可以用的图片类型
            // Bitmap dBitmap = BitmapFactory.decodeFile(photo);
            // drawable = new BitmapDrawable(dBitmap);
            // //////////////////////////////////
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return headimage;
    }
    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        frontPath=result.getImage().getCompressPath();
        Picasso.with(this).load(new File(frontPath)).into(civ_icon);
        basePic=getImageToView(frontPath);
        Log.d("takeSuccess","frontPath="+frontPath);
        Log.d("takeSuccess","basePic="+basePic);
        //Glide.with(this).load(new File(frontPath)).into(icon);
    }
    private void selectImage() {
        String filepath="/temp/"+System.currentTimeMillis() + ".jpg";
        File file=new File(Environment.getExternalStorageDirectory(),filepath);
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
    }

    private void joinFamily() {
        HttpMethods.getInstance().updateMessage(new BaseObserver<BrokenUp>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                BrokenUp houseDetil= (BrokenUp) t;
                Log.e("getData","执行joinFamily方法返回"+houseDetil.getMessage());
                System.out.println(t.getMessage()+"");
                Toast.makeText(EditProFileActivity.this, houseDetil.getMessage(), Toast.LENGTH_SHORT).show();
                userinfoBean.setUserName(userName);
                userinfoBean.setUserBirthday(userBirthday);
                userinfoBean.setUserConstellation(userConstellation);
                userinfoBean.setUserJob(userJob);
                userinfoBean.setUserFavourite(userFavourite);
                userinfoBean.setUserSex(userSex);
                UserLocalData.putUser(EditProFileActivity.this,userinfoBean);
                finish();
                //adapter.addAll(viewDataBeanList);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },userName,userSex,userBirthday,userConstellation,userJob,userPhone,userFavourite);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_nick_name:{

            }break;
            case R.id.ll_commit:{
                getUserMessage();
                if (basePic!=null) {
                    upPic();
                }else {
                    joinFamily();
                }
            }break;
            case R.id.civ_icon:{
                selectImage();
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

    private void upPic() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("phone",userPhone);
        map.put("base64Pic",basePic);
        try {
            HttpMethods.getInstance().upImages(new BaseObserver<IconUp>() {
                @Override
                protected void onSuccees(BaseBean t) throws Exception {
                    IconUp houseDetil= (IconUp) t;
                    Log.e("getData","执行joinFamily方法返回"+houseDetil.getResult());
                    Toast.makeText(EditProFileActivity.this, houseDetil.getMessage(), Toast.LENGTH_SHORT).show();
                    userinfoBean.setUserIcon(houseDetil.getNewImageURL());
                    UserLocalData.putUser(EditProFileActivity.this,userinfoBean);
                    /*userinfoBean.setUserName(userName);
                    userinfoBean.setUserBirthday(userBirthday);
                    userinfoBean.setUserConstellation(userConstellation);
                    userinfoBean.setUserJob(userJob);
                    userinfoBean.setUserFavourite(userFavourite);
                    userinfoBean.setUserSex(userSex);
                    UserLocalData.putUser(EditProFileActivity.this,userinfoBean);
                    finish();*/

                    joinFamily();
                    //adapter.addAll(viewDataBeanList);
                }

                @Override
                protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                    System.out.print("1111111111111111");

                }
            },map);
        } catch (Exception e) {
            e.printStackTrace();
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
        //currentDate.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                currentDate.setText(time.split(" ")[0]);
                userBirthday=time.split(" ")[0];
                Log.d("customDatePicker1","格式前="+time);
                Log.d("customDatePicker1","格式后="+time.split(" ")[0]);
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
                userSex=time;
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
                userConstellation=time;
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
        jobList.add("文员");
        jobList.add("销售");
        jobList.add("健身教练");
        jobList.add("司机");
        jobList.add("其他");
        jobPicker = new CustomSinglePicker(this, jobHandler,jobList,"选择职业"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        jobPicker.setIsLoop(false); // 允许循环滚动

        ArrayList<String> interestList=new ArrayList<>();
        interestList.add("足球");
        interestList.add("篮球");
        interestList.add("跆拳道");
        interestList.add("射箭");
        interestList.add("蹦极");
        interestList.add("煮饭");
        interestList.add("爬山");
        interestList.add("画画");
        interestList.add("骑单车");
        interestList.add("睡懒觉");
        interestList.add("羽毛球");
        interestDatePicker = new CustomSinglePicker(this, interestHandler,interestList,"选择兴趣"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        interestDatePicker.setIsLoop(false); // 允许循环滚动

    }
}
