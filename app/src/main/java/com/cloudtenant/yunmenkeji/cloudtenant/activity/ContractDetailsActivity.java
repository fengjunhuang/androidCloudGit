package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BuildingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.gersion.library.base.BaseActivity;


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
        button=findViewById(R.id.button);
        title=findViewById(R.id.title);
        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        getData();
    }

    private void getData() {
        HttpMethods.getInstance().buildingInfo(new BaseObserver<BuildingInfo>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                BuildingInfo houseDetil= (BuildingInfo) t;
                details.setText(houseDetil.getContract());

                Log.e("onSuccees",houseDetil.getViewData());
                Log.e("onSuccees",houseDetil.getContract());

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }
}
