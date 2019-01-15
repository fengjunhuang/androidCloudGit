package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.gersion.library.base.BaseActivity;



/**
 * Created by tlol20 on 2017/6/14
 */
public class RequestActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        userinfoBean= UserLocalData.getUser(this);
        if (userinfoBean!=null) {
            userPhone=userinfoBean.getUserPhone();
        }
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
        findViewById(R.id.commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=editText.getText().toString();
                upPic();
            }
        });
        editText=findViewById(R.id.editText);
        //tvOpinion.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

    }
    EditText editText;
    UserinfoBean userinfoBean;
    String userPhone,s;
    private void upPic() {
        try {
            HttpMethods.getInstance().feedbackProblem(new BaseObserver<BrokenUp>() {
                @Override
                protected void onSuccees(BaseBean t) throws Exception {
                    BrokenUp houseDetil= (BrokenUp) t;
                    Log.e("getData","执行joinFamily方法返回"+houseDetil.getResult());
                    System.out.println(t.getMessage()+"");
                    Toast.makeText(RequestActivity.this, houseDetil.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                }
            },userPhone,s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
