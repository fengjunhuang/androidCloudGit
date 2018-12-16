package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageOther extends BaseBeanC{


    /**
     * id : 10
     * maxPage : 1
     * viewData : [{"contractName":"明珠新村6栋201的住房申请已经批准,请您抓紧时间付款","contractTime":"2019-09-09 09:09:09","contractID":"11111111111","contractType":1,"contractAlipay":"1111111111","contractWechat":"2222222222","contractTotal":"998"},{"contractName":"明珠新村公寓的房东已经对你的退房申请进行了相关的操作","contractTime":"2019-09-09 09:09:09","contractID":"11111111111","contractType":2,"contractAlipay":"","contractWechat":"","contractTotal":""}]
     */

    private String id;
    private String maxPage;
    private List<ViewDataBean> viewDataX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(String maxPage) {
        this.maxPage = maxPage;
    }

    public List<ViewDataBean> getViewDataX() throws Exception {
        return JSON.parseArray(getViewData(),MessageOther.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        /**
         * contractName : 明珠新村6栋201的住房申请已经批准,请您抓紧时间付款
         * contractTime : 2019-09-09 09:09:09
         * contractID : 11111111111
         * contractType : 1
         * contractAlipay : 1111111111
         * contractWechat : 2222222222
         * contractTotal : 998
         */

        private String contractName;
        private String contractTime;
        private String contractID;
        private int contractType;
        private String contractAlipay;
        private String contractWechat;
        private String contractTotal;

        public String getContractName() {
            return contractName;
        }

        public void setContractName(String contractName) {
            this.contractName = contractName;
        }

        public String getContractTime() {
            return contractTime;
        }

        public void setContractTime(String contractTime) {
            this.contractTime = contractTime;
        }

        public String getContractID() {
            return contractID;
        }

        public void setContractID(String contractID) {
            this.contractID = contractID;
        }

        public int getContractType() {
            return contractType;
        }

        public void setContractType(int contractType) {
            this.contractType = contractType;
        }

        public String getContractAlipay() {
            return contractAlipay;
        }

        public void setContractAlipay(String contractAlipay) {
            this.contractAlipay = contractAlipay;
        }

        public String getContractWechat() {
            return contractWechat;
        }

        public void setContractWechat(String contractWechat) {
            this.contractWechat = contractWechat;
        }

        public String getContractTotal() {
            return contractTotal;
        }

        public void setContractTotal(String contractTotal) {
            this.contractTotal = contractTotal;
        }
    }
}
