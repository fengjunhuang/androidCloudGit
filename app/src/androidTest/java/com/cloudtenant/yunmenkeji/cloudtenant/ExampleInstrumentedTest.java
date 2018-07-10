package com.cloudtenant.yunmenkeji.cloudtenant;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cloudtenant.yunmenkeji.cloudtenant", appContext.getPackageName());
    }
    public void test(){

//        HttpMethods.getInstance().login(new BaseObserver<String>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                System.out.println(t);
//
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//                System.out.println(e);
//            }
//
//            @Override
//            public void onNext(BaseBean baseBean) {
//
//            }
//        });
    }
}
