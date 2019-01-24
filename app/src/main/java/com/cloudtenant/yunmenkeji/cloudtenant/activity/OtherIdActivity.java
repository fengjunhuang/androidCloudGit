package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.DialogTitle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IdDetails;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IdFront;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherId;
import com.cloudtenant.yunmenkeji.cloudtenant.util.JSONUtil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.Youtu;
import com.gersion.library.base.BaseActivity;
import com.yzs.yzslibrary.util.LogUtils;
import com.yzs.yzslibrary.util.StringUtils;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cloudtenant.yunmenkeji.cloudtenant.activity.CommitIdActivity.OTHER_REQUEST_CODE;


/**
 * Created by tlol20 on 2017/6/14
 */
public class OtherIdActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout verso,front;
    private ImageView iv_front,iv_verso;
    private EditText et_phone;
    private boolean isFront;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_other_id);
        iv_front=findViewById(R.id.iv_front);
        iv_verso=findViewById(R.id.iv_verso);
        et_phone=findViewById(R.id.et_phone);
        verso=findViewById(R.id.verso);
        front=findViewById(R.id.front);
        iv_verso.setOnClickListener(this);
        iv_front.setOnClickListener(this);
        findViewById(R.id.commit).setOnClickListener(this);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    //一般的Dialog
    public void normalDialog(String s){
        AlertDialog.Builder bulider =new AlertDialog.Builder(this);
        bulider.setMessage(s);
        bulider.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
            }
        });
        bulider.create().show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_sign:{
            }break;
            case R.id.commit:{

                String phone=et_phone.getText().toString().trim();
                if (checkPhoneNum(phone)){
                    if (idDetails!=null){
                        if (StringUtils.isEmpty(idDetails.getName())&&StringUtils.isEmpty(idDetails.getId())){
                            normalDialog("身份证照片不正确，无法获取身份信息！请重新上传");
                        }else {
                            OtherId otherId=new OtherId(idDetails.getId(),idDetails.getName(),phone,getImageToView(frontPath),getImageToView(versoPath));
                            Log.d("takePhoto","otherId="+otherId.toString());
                            PreferencesUtils.putString(this,"OtherId",JSONUtil.toJSON(otherId));
                            Log.d("takePhoto","toJSON="+JSONUtil.toJSON(otherId));
                            setResult(OTHER_REQUEST_CODE);
                            finish();
                        }
                    }else {
                        normalDialog("请提交身份证照片！");
                    }
                }

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
        }
    }
    String frontPath,versoPath;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("takePhoto","Myfinish完成=进入onActivityResult");
        Log.d("takePhoto","Myfinish完成=进入onActivityResult》requestCode="+requestCode+"》》》resultCode="+resultCode);

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
                frontPath=file1.getPath();
                getIdDetails(frontPath,0);
            }else {
                verso.setVisibility(View.GONE);
                //本地文件
                File file = new File(Environment.getExternalStorageDirectory(), "idFront.jpg");
                //加载图片
                Log.d("takePhoto","进入onActivityResult设置图片路径="+file.getPath());
                versoPath=file.getPath();
                getIdDetails(versoPath,1);
                Glide.with(this).load(file).signature(new StringSignature(GetNowTime())).into(iv_verso);
                //iv_verso.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idServo.jpg"));
            }
        }
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
    IdDetails idDetails;
    IdFront idFront;
    private void getBean(boolean isFront,String s) {
        if (isFront) {
            idDetails= JSONUtil.fromJson(s,IdDetails.class);
            Log.d("takePhoto","getId="+idDetails.getId());
            Log.d("takePhoto","getName="+idDetails.getName());
            Log.d("takePhoto","getErrormsg="+idDetails.getErrormsg());

            //LogUtils.e(idDetails.toString());
        }else {
            idFront=JSONUtil.fromJson(s,IdFront.class);
            //LogUtils.e(idFront.toString());
        }

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
    private boolean checkPhoneNum(String phone) {

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(OtherIdActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phone.length() != 11) {
            Toast.makeText(OtherIdActivity.this, "手机号码长度不对", Toast.LENGTH_SHORT).show();
            return false;
        }


        String rule = "^1(3|5|7|8|4|6)\\d{9}";
        Pattern p = Pattern.compile(rule);
        Matcher m = p.matcher(phone);

        if (!m.matches()) {
            Toast.makeText(OtherIdActivity.this, "您输入的手机号码格式不正确", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
    private String APP_ID = "10140989";
    private String SECRET_ID = "AKIDEH9m9G3oEjz0qRIukOo6C4j9JhsqpATX";
    private String SECRET_KEY = "zmMkuqZO1RdaJowviGZcQ3UhhU7WjiSH";

}
