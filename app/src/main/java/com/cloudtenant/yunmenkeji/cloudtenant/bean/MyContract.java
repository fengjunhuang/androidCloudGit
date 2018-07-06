package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyContract extends BaseBean{


    /**
     * id : 9
     * viewData : [{"contractName":"明珠新村6栋205合同","contractUrl":"http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg","contractID":"123123123123","contractEndTime":"2018-06-23","contractType":0},{"contractName":"家家公寓6栋205合同","contractUrl":"http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg","contractID":"123123123123","contractEndTime":"2018-09-24","contractType":1}]
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
        return JSON.parseArray(getViewData(),MyContract.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        /**
         * contractName : 明珠新村6栋205合同
         * contractUrl : http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg
         * contractID : 123123123123
         * contractEndTime : 2018-06-23
         * contractType : 0
         */

        private String contractName;
        private String contractUrl;
        private String contractID;
        private String contractEndTime;
        private int contractType;

        public String getContractName() {
            return contractName;
        }

        public void setContractName(String contractName) {
            this.contractName = contractName;
        }

        public String getContractUrl() {
            return contractUrl;
        }

        public void setContractUrl(String contractUrl) {
            this.contractUrl = contractUrl;
        }

        public String getContractID() {
            return contractID;
        }

        public void setContractID(String contractID) {
            this.contractID = contractID;
        }

        public String getContractEndTime() {
            return contractEndTime;
        }

        public void setContractEndTime(String contractEndTime) {
            this.contractEndTime = contractEndTime;
        }

        public int getContractType() {
            return contractType;
        }

        public void setContractType(int contractType) {
            this.contractType = contractType;
        }
    }
}
