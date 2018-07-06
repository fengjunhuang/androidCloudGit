package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MyFamilyData extends BaseBean{


    /**
     * id : 1
     * viewData : [{"familyGroupID":"13800138000","familyGroupName":"你好凯蒂","familyGroupIsAdmin":true}]
     */

    private String id;
    private List<ViewDataBean> viewDataX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ViewDataBean> getViewDataX() throws Exception {
        return JSON.parseArray(getViewData(),MyFamilyData.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        /**
         * familyGroupID : 13800138000
         * familyGroupName : 你好凯蒂
         * familyGroupIsAdmin : true
         */

        private String familyGroupID;
        private String familyGroupName;
        private boolean familyGroupIsAdmin;

        public String getFamilyGroupID() {
            return familyGroupID;
        }

        public void setFamilyGroupID(String familyGroupID) {
            this.familyGroupID = familyGroupID;
        }

        public String getFamilyGroupName() {
            return familyGroupName;
        }

        public void setFamilyGroupName(String familyGroupName) {
            this.familyGroupName = familyGroupName;
        }

        public boolean isFamilyGroupIsAdmin() {
            return familyGroupIsAdmin;
        }

        public void setFamilyGroupIsAdmin(boolean familyGroupIsAdmin) {
            this.familyGroupIsAdmin = familyGroupIsAdmin;
        }
    }
}
