package com.cloudtenant.yunmenkeji.cloudtenant.model;


import java.io.Serializable;
import java.util.List;

public class BillHistoryModel extends BaseBean {

    private List<BillHistoryModel.ViewDataBean> viewData;

    public List<BillHistoryModel.ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<BillHistoryModel.ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean implements Serializable {
        private String payStatus;
        private String billNumber;
        private String payID;
        private String month;
        private String power;
        private String other;
        private Boolean complete;
        private String billTimes;
        private String roomRent;
        private String water;
        private String roomRentId;
        private String date;
        private String title;
        private String signMoney;

        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

        public String getBillNumber() {
            return billNumber;
        }

        public void setBillNumber(String billNumber) {
            this.billNumber = billNumber;
        }

        public String getPayID() {
            return payID;
        }

        public void setPayID(String payID) {
            this.payID = payID;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public Boolean getComplete() {
            return complete;
        }

        public void setComplete(Boolean complete) {
            this.complete = complete;
        }

        public String getBillTimes() {
            return billTimes;
        }

        public void setBillTimes(String billTimes) {
            this.billTimes = billTimes;
        }

        public String getRoomRent() {
            return roomRent;
        }

        public void setRoomRent(String roomRent) {
            this.roomRent = roomRent;
        }

        public String getWater() {
            return water;
        }

        public void setWater(String water) {
            this.water = water;
        }

        public String getRoomRentId() {
            return roomRentId;
        }

        public void setRoomRentId(String roomRentId) {
            this.roomRentId = roomRentId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSignMoney() {
            return signMoney;
        }

        public void setSignMoney(String signMoney) {
            this.signMoney = signMoney;
        }
    }

}
