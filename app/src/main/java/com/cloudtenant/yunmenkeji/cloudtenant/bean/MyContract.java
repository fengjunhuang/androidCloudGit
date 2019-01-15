package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MyContract extends BaseBean {
    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean {
        /**
         * contractEndTime : 2019-11-12
         * contractID : 7a8b671c-cfb9-4824-96ec-f29eff515c5d
         * contractName : 越秀•滨海新城 203
         * contractType : 1
         * contractUrl : /chl/upload/app/2018-11-12/5e7c8308-a4a5-4657-9e55-48a5b4b2eb72userContractAll.jpg
         */

        private String contractEndTime;
        private String contractID;
        private String contractName;
        private String contractType;
        private String contractUrl;

        public String getContractEndTime() {
            return contractEndTime;
        }

        public void setContractEndTime(String contractEndTime) {
            this.contractEndTime = contractEndTime;
        }

        public String getContractID() {
            return contractID;
        }

        public void setContractID(String contractID) {
            this.contractID = contractID;
        }

        public String getContractName() {
            return contractName;
        }

        public void setContractName(String contractName) {
            this.contractName = contractName;
        }

        public String getContractType() {
            return contractType;
        }

        public void setContractType(String contractType) {
            this.contractType = contractType;
        }

        public String getContractUrl() {
            return contractUrl;
        }

        public void setContractUrl(String contractUrl) {
            this.contractUrl = contractUrl;
        }
    }


    /*private List<ViewDataBean> viewDataX;

    public List<ViewDataBean> getViewDataX() throws Exception {
        return JSON.parseArray(getViewData(),MyContract.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }
    public static class ViewDataBean implements Serializable {
        *//**
         * contractName : 明珠新村6栋205合同
         * contractUrl : http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg
         * contractID : 123123123123
         * contractEndTime : 2018-06-23
         * contractType : 0
         *//*

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
    }*/



}
