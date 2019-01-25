package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.IdAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageRoomAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IdDetails;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IdFront;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherId;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.JSONUtil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.util.Youtu;
import com.cloudtenant.yunmenkeji.cloudtenant.util.base64.Test;
import com.cloudtenant.yunmenkeji.cloudtenant.util.misc.BASE64Encoder;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.yzs.yzslibrary.util.LogUtils;
import com.yzs.yzslibrary.util.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import dmax.dialog.SpotsDialog;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by tlol20 on 2017/6/14
 */
public class CommitIdActivity extends BaseActivity implements View.OnClickListener{
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
    private ImageView iv_sign,iv_front,iv_verso;
    private LinearLayout verso,front;
    boolean isFront;
    private SpotsDialog mDialog;
    private EditText et_phone;

    public static final int SIGN_REQUEST_CODE=100;
    public static final int OTHER_REQUEST_CODE=101;
    private List<OtherId> list=new ArrayList<>();
    private EasyRecyclerView recyclerView;
    private IdAdapter adapter;
    private RecyclerArrayAdapter.ItemView viewFooter;
    //提交所需数据
    private String userPhone;
    private String buildingID;
    private String roomId;
    private String other;
    private String IDNum;
    private String name;
    private String roomNum;
    private String userIDFront;
    private String userIDBack;
    private String userSign;
    private String contractTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_id);
        mDialog = new SpotsDialog(this);
        userPhone= UserLocalData.getUser(this).getUserPhone();
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        buildingID=intent.getStringExtra("buildingID");
        roomId=intent.getStringExtra("roomId");
        roomNum=intent.getStringExtra("roomNum");
        contractTime=intent.getStringExtra("contractTime");
        Log.d("takePhoto","buildingID="+buildingID);
        Log.d("takePhoto","roomId="+roomId);
        Log.d("takePhoto","roomNum="+roomNum);
        Log.d("takePhoto","contractTime="+contractTime);
        iv_sign=findViewById(R.id.iv_sign);
        et_phone=findViewById(R.id.et_phone);
        verso=findViewById(R.id.verso);
        front=findViewById(R.id.front);
        iv_front=findViewById(R.id.iv_front);
        iv_verso=findViewById(R.id.iv_verso);
        iv_sign.setOnClickListener(this);
        iv_front.setOnClickListener(this);
        findViewById(R.id.tv_commit).setOnClickListener(this);
        iv_verso.setOnClickListener(this);
        et_phone.setText(userPhone);
        /*TextView textView=findViewById(R.id.tv_phone);
        textView.setText("手机号码");*/
        recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter = new IdAdapter(this);
        viewFooter=new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View view= LayoutInflater.from(CommitIdActivity.this).inflate(R.layout.booder_id,parent,false);
                view.findViewById(R.id.iv_other).setOnClickListener(CommitIdActivity.this);
                return view;
            }
            @Override
            public void onBindView(View headerView) {
            }
        };
        adapter.addFooter(viewFooter);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                normalDialog(position);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_sign:{
                startActivityForResult(new Intent(this,SignViewActivity.class),SIGN_REQUEST_CODE);
            }break;
            case R.id.iv_other:{
                startActivityForResult(new Intent(this,OtherIdActivity.class),OTHER_REQUEST_CODE);
            }break;
            case R.id.iv_front :{
                Intent intent=new Intent(this,IdCammerActivity.class);
                PreferencesUtils.putBoolean(this,"isFront",true);
                intent.putExtra("isFront",false);
                isFront=true;
                 Log.d("takePhoto","点击正面="+isFront);
                startActivityForResult(intent,103);
            }break;
            case R.id.iv_verso :{
                Intent intent=new Intent(this,IdCammerActivity.class);
                intent.putExtra("isFront",true);
                isFront=false;
                PreferencesUtils.putBoolean(this,"isFront",false);
                 Log.d("takePhoto","点击反面="+isFront);
                startActivityForResult(intent,104);
            }break;
            case R.id.tv_commit:{
                 Log.d("tv_commit","userIDBack="+StringUtils.isEmpty(userIDBack));
                 Log.d("tv_commit","userSign="+StringUtils.isEmpty(userSign));
                 Log.d("tv_commit","userIDFront="+StringUtils.isEmpty(userIDFront));
                 Log.d("tv_commit", String.valueOf("idDetails="+idDetails!=null));
                if (StringUtils.isEmpty(userIDBack)||StringUtils.isEmpty(userSign)||StringUtils.isEmpty(userIDFront)||idDetails==null){
                    normalDialog1("请提交身份证照片与签名");
                }else {
                    if (idDetails.getErrorcode()==0){
                        mDialog.show();
                        other=JSONUtil.toJSON(list);
                        commit();
                    }else {
                        normalDialog1("身份证照片不正确，无法获取身份信息！请重新上传");
                    }
                }
            }break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("takePhoto","Myfinish完成=进入onActivityResult");
        Log.d("takePhoto","Myfinish完成=进入onActivityResult》requestCode="+requestCode+"》》》resultCode="+resultCode);

        if (resultCode == SIGN_REQUEST_CODE) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(path, options);
            iv_sign.setImageBitmap(bm);
            userSign=path;
        } else if (resultCode == OTHER_REQUEST_CODE) {
            //Glide.with(this).load(path1 + ".sign").skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(binding.img2);
            String otherIdString=PreferencesUtils.getString(this,"OtherId");
            Log.d("takePhoto","OtherId="+otherIdString);
            OtherId otherId=JSONUtil.fromJson(otherIdString,OtherId.class);
            list.add(otherId);
            adapter.add(otherId);
        }
        if (resultCode==11){
            Log.d("takePhoto","isFront="+isFront);

            if (isFront) {
                front.setVisibility(View.GONE);
                //本地文件
                File file1 = new File(Environment.getExternalStorageDirectory(), "idServo.jpg");
                //加载图片
                Glide.with(this).load(file1).signature(new StringSignature(GetNowTime())).into(iv_front);
                //iv_front.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idFront.jpg"));
                Log.d("takePhoto","进入onActivityResult设置图片路径="+file1.getPath());
                getIdDetails(file1.getPath(),0);
                userIDFront=file1.getPath();
            }else {
                verso.setVisibility(View.GONE);
                //本地文件
                File file = new File(Environment.getExternalStorageDirectory(), "idFront.jpg");
                //加载图片
                Log.d("takePhoto","进入onActivityResult设置图片路径="+file.getPath());
                getIdDetails(file.getPath(),1);
                userIDBack=file.getPath();
                Glide.with(this).load(file).signature(new StringSignature(GetNowTime())).into(iv_verso);
                //iv_verso.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idServo.jpg"));
            }
        }
    }

    private void commit() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("userPhone",userPhone);
        map.put("buildingID",buildingID);
        map.put("roomId",roomId);
        map.put("other","");
        map.put("IDNum",idDetails.getId());
        map.put("name",idDetails.getName());
        map.put("landLoardPhone",userPhone);
        map.put("roomNum",roomNum);
        map.put("contractTime",contractTime);
        map.put("userIDBack",getImageToView(userIDBack));
        map.put("userIDFront",getImageToView(userIDFront));
        map.put("userSign",getImageToView(userSign));
        //TODO:
        HttpMethods.getInstance().signContractAction(new BaseObserver<BrokenUp>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                BrokenUp houseDetil= (BrokenUp) t;
                Log.e("getData","执行joinFamily方法返回"+houseDetil.getMessage());
                System.out.println(t.getMessage()+"");
                Toast.makeText(CommitIdActivity.this, houseDetil.getMessage(), Toast.LENGTH_SHORT).show();
                //adapter.addAll(viewDataBeanList);
            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },map);
    }

    //一般的Dialog
    public void normalDialog1(String s){
        AlertDialog.Builder bulider =new AlertDialog.Builder(this);
        bulider.setTitle("提示");
        bulider.setMessage(s);
        bulider.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
            }
        });
        bulider.create().show();
    }
    //一般的Dialog
    public void normalDialog(final int s){
        AlertDialog.Builder bulider =new AlertDialog.Builder(this);
        bulider.setMessage("入住人"+list.get(s).getName()+"的信息");

        bulider.setPositiveButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                list.remove(s);
                adapter.remove(s);
                dialog.dismiss();
            }
        });
        bulider.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        bulider.create().show();
    }
    private Bitmap theSelectedImage = null;
    private void getIdDetails(String filePath, final int type) {

        theSelectedImage = getBitmap(filePath, 1000, 1000);
        new Thread(new Runnable() {
            @Override
            public void run() {

                if (theSelectedImage != null) {
                    try {
                        Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT);
                        JSONObject respose = faceYoutu.IdcardOcr(theSelectedImage, type);
                        String s=respose.toString();
                        LogUtils.e(s);
                        getBean(isFront,s);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
    IdDetails idDetails;
    IdFront idFront;
    private void getBean(boolean isFront,String s) {
        if (isFront) {
            idDetails=JSONUtil.fromJson(s,IdDetails.class);

                        LogUtils.e(idDetails.toString());
        }else {
            idFront=JSONUtil.fromJson(s,IdFront.class);
                        LogUtils.e(idFront.toString());
        }

    }

    private Bitmap getBitmap(String path , int maxWidth, int maxHeight){
        //先解析图片边框的大小
        Bitmap bm = null;
        File file = new File(path);
        if(file.exists()) {
            BitmapFactory.Options ops = new BitmapFactory.Options();
            ops.inJustDecodeBounds = true;
            ops.inSampleSize = 1;
            BitmapFactory.decodeFile(path, ops);
            int oHeight = ops.outHeight;
            int oWidth = ops.outWidth;

            //控制压缩比
            int contentHeight = maxWidth;
            int contentWidth = maxHeight;
            if (((float) oHeight / contentHeight) < ((float) oWidth / contentWidth)) {
                ops.inSampleSize = (int) Math.ceil((float) oWidth / contentWidth);
            } else {
                ops.inSampleSize = (int) Math.ceil((float) oHeight / contentHeight);
            }
            ops.inJustDecodeBounds = false;
            bm = BitmapFactory.decodeFile(path, ops);

        }

        return bm;
    }


    public  String GetNowTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
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
    private String APP_ID = "10140989";
    private String SECRET_ID = "AKIDEH9m9G3oEjz0qRIukOo6C4j9JhsqpATX";
    private String SECRET_KEY = "zmMkuqZO1RdaJowviGZcQ3UhhU7WjiSH";


}
