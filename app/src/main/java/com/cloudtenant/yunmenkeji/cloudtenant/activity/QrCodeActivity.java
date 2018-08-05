package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.util.QrUtils;
import com.gersion.library.base.BaseActivity;


/**
 * Created by tlol20 on 2017/6/14
 */
public class QrCodeActivity extends BaseActivity {

    private String content;
    private ImageView iv_qr_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        String familyID=getIntent().getStringExtra("familyID");
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         iv_qr_code=findViewById(R.id.iv_qr_code);

            content="{\n" +
                    "\t\"cellCost\": \"\",\n" +
                    "\t\"cellBuildID\": \"\",\n" +
                    "\t\"cellImage\": \"\",\n" +
                    "\t\"qrType\": \"1\",\n" +
                    "\t\"familyID\": \""+familyID+"\",\n" +
                    "\t\"cellName\": \"\",\n" +
                    "\t\"cellRemain\": \"\",\n" +
                    "\t\"cellRoomID\": \"\",\n" +
                    "\t\"cellAddress\": \"\"\n" +
                    "}";
        Log.d("getData","width="+iv_qr_code.getWidth()+">>>>>height="+iv_qr_code.getHeight());

        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        iv_qr_code.measure(w,h);
        Log.d("getData","width="+iv_qr_code.getMeasuredWidth()+">>>>>height="+iv_qr_code.getMeasuredHeight());


    }


    @Override
    protected void onResume() {
        super.onResume();
        Bitmap bitmap = QrUtils.createQRImage(content, iv_qr_code.getMeasuredWidth(),  iv_qr_code.getMeasuredHeight());
        iv_qr_code.setImageBitmap(bitmap);
    }
}
