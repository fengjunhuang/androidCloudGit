package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MessageOther extends BaseBean{


    /**
     * landlordNewList : [{"cellReaded":"0","createTime":"2018-12-12 16:44:36","id":"a50662cb-5faa-4ff6-bd29-85a43fa0eb60","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付3920.0元","messageID":"a50662cb-5faa-4ff6-bd29-85a43fa0eb60","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"XAGHmF6V","roomRentId":"","signId":"518ee2bf-6b1a-4d6f-b5a5-f1664a5b8fbe","type":"5","water":"","widoutTradeMoney":"3920.0","widoutTradeNo":"72e9d886-7c5b-49c3-b83d-957edbef2f1a"},{"cellReaded":"0","createTime":"2018-11-30 16:50:45","id":"28b0aacb-54d4-43e8-91d1-bf71cbc75538","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付3308.0元","messageID":"28b0aacb-54d4-43e8-91d1-bf71cbc75538","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"Dimef3Oj","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"3308.0","widoutTradeNo":"6c698f70-cd02-45df-9cb3-6864da92c619"},{"cellReaded":"0","createTime":"2018-11-30 16:50:36","id":"1538bf23-c287-426e-a0fd-60b91ad94e7c","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付4444.0元","messageID":"1538bf23-c287-426e-a0fd-60b91ad94e7c","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"kAO3fFd7","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"4444.0","widoutTradeNo":"d2f860f5-d30d-4821-b300-f5f4775e976c"},{"cellReaded":"0","createTime":"2018-11-30 16:50:25","id":"bb52b1c7-d921-4532-bf40-96b9af929dbe","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付3100.0元","messageID":"bb52b1c7-d921-4532-bf40-96b9af929dbe","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"M29chmbL","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"3100.0","widoutTradeNo":"183996ad-1e9d-4b77-9af8-5d845094d10f"},{"cellReaded":"0","createTime":"2018-11-30 16:50:17","id":"3df95542-264f-4678-9851-cc5dcb2734ba","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付3100.0元","messageID":"3df95542-264f-4678-9851-cc5dcb2734ba","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"M29chmbL","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"3100.0","widoutTradeNo":"cbb5fc59-be2b-442a-b9d2-fc16dd73993c"},{"cellReaded":"0","createTime":"2018-11-30 15:46:35","id":"3a7944fe-d2c8-4def-8cf6-315204b36024","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付4500.0元","messageID":"3a7944fe-d2c8-4def-8cf6-315204b36024","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"1","phone":"13068893276","power":"","rent":"","roomId":"LaCeulg2","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"4500.0","widoutTradeNo":"92ba193f-9c3a-4b6e-bb40-f61ad037ee93"},{"cellReaded":"0","createTime":"2018-11-30 15:45:33","id":"89154891-60d4-4b18-8667-bf385fc2e1fd","messageContract":"房东已经同意了您的签约申请，请缴费完成签约。需支付4500.0元","messageID":"89154891-60d4-4b18-8667-bf385fc2e1fd","messageTitle":"房东已经同意了您的签约申请，请缴费完成签约","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"LaCeulg2","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"4500.0","widoutTradeNo":"6a373302-e5c9-49d0-9a57-4c7ab946f4ac"},{"cellReaded":"0","createTime":"2018-11-24 17:55:09","id":"d7665375-d72e-4007-9aff-fac8026fe6ed","messageContract":"很遗憾，房东已经拒绝了您的签约申请。","messageID":"d7665375-d72e-4007-9aff-fac8026fe6ed","messageTitle":"健健康康？我","messageType":"0","other":"","pay_status":"0","phone":"13068893276","power":"","rent":"","roomId":"kAO3fFd7","roomRentId":"","signId":"","type":"5","water":"","widoutTradeMoney":"","widoutTradeNo":""}]
     * message  : 查询消息列表成功
     * result  : true
     */

    private List<LandlordNewListBean> landlordNewList;



    public List<LandlordNewListBean> getLandlordNewList() {
        return landlordNewList;
    }

    public void setLandlordNewList(List<LandlordNewListBean> landlordNewList) {
        this.landlordNewList = landlordNewList;
    }

    public static class LandlordNewListBean {
        @Override
        public String toString() {
            return "LandlordNewListBean{" +
                    "cellReaded='" + cellReaded + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", id='" + id + '\'' +
                    ", messageContract='" + messageContract + '\'' +
                    ", messageID='" + messageID + '\'' +
                    ", messageTitle='" + messageTitle + '\'' +
                    ", messageType='" + messageType + '\'' +
                    ", other='" + other + '\'' +
                    ", pay_status='" + pay_status + '\'' +
                    ", phone='" + phone + '\'' +
                    ", power='" + power + '\'' +
                    ", rent='" + rent + '\'' +
                    ", roomId='" + roomId + '\'' +
                    ", roomRentId='" + roomRentId + '\'' +
                    ", signId='" + signId + '\'' +
                    ", type='" + type + '\'' +
                    ", water='" + water + '\'' +
                    ", widoutTradeMoney='" + widoutTradeMoney + '\'' +
                    ", widoutTradeNo='" + widoutTradeNo + '\'' +
                    '}';
        }

        /**
         * cellReaded : 0
         * createTime : 2018-12-12 16:44:36
         * id : a50662cb-5faa-4ff6-bd29-85a43fa0eb60
         * messageContract : 房东已经同意了您的签约申请，请缴费完成签约。需支付3920.0元
         * messageID : a50662cb-5faa-4ff6-bd29-85a43fa0eb60
         * messageTitle : 房东已经同意了您的签约申请，请缴费完成签约
         * messageType : 0
         * other :
         * pay_status : 0
         * phone : 13068893276
         * power :
         * rent :
         * roomId : XAGHmF6V
         * roomRentId :
         * signId : 518ee2bf-6b1a-4d6f-b5a5-f1664a5b8fbe
         * type : 5
         * water :
         * widoutTradeMoney : 3920.0
         * widoutTradeNo : 72e9d886-7c5b-49c3-b83d-957edbef2f1a
         */

        private String cellReaded;
        private String createTime;
        private String id;
        private String messageContract;
        private String messageID;
        private String messageTitle;
        private String messageType;
        private String other;
        private String pay_status;
        private String phone;
        private String power;
        private String rent;
        private String roomId;
        private String roomRentId;
        private String signId;
        private String type;
        private String water;
        private String widoutTradeMoney;
        private String widoutTradeNo;

        public String getCellReaded() {
            return cellReaded;
        }

        public void setCellReaded(String cellReaded) {
            this.cellReaded = cellReaded;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessageContract() {
            return messageContract;
        }

        public void setMessageContract(String messageContract) {
            this.messageContract = messageContract;
        }

        public String getMessageID() {
            return messageID;
        }

        public void setMessageID(String messageID) {
            this.messageID = messageID;
        }

        public String getMessageTitle() {
            return messageTitle;
        }

        public void setMessageTitle(String messageTitle) {
            this.messageTitle = messageTitle;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getRent() {
            return rent;
        }

        public void setRent(String rent) {
            this.rent = rent;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getRoomRentId() {
            return roomRentId;
        }

        public void setRoomRentId(String roomRentId) {
            this.roomRentId = roomRentId;
        }

        public String getSignId() {
            return signId;
        }

        public void setSignId(String signId) {
            this.signId = signId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWater() {
            return water;
        }

        public void setWater(String water) {
            this.water = water;
        }

        public String getWidoutTradeMoney() {
            return widoutTradeMoney;
        }

        public void setWidoutTradeMoney(String widoutTradeMoney) {
            this.widoutTradeMoney = widoutTradeMoney;
        }

        public String getWidoutTradeNo() {
            return widoutTradeNo;
        }

        public void setWidoutTradeNo(String widoutTradeNo) {
            this.widoutTradeNo = widoutTradeNo;
        }
    }
}
