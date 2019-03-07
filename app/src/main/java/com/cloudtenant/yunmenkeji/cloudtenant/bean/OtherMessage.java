package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class OtherMessage extends BaseBean {

    private List<IsOverLandLordNewBean> isOverLandLordNew;
    private List<NoOverLandLordNewBean> noOverLandLordNew;

    public List<IsOverLandLordNewBean> getIsOverLandLordNew() {
        return isOverLandLordNew;
    }

    public void setIsOverLandLordNew(List<IsOverLandLordNewBean> isOverLandLordNew) {
        this.isOverLandLordNew = isOverLandLordNew;
    }

    public List<NoOverLandLordNewBean> getNoOverLandLordNew() {
        return noOverLandLordNew;
    }

    public void setNoOverLandLordNew(List<NoOverLandLordNewBean> noOverLandLordNew) {
        this.noOverLandLordNew = noOverLandLordNew;
    }

    public static class IsOverLandLordNewBean {
        /**
         * cellReaded : 0
         * createTime : 2019-02-21 21:53:45
         * deposit : 3500.0
         * id : 799d2fb1-1e48-4fc1-97bd-2e9ce00d730b
         * messageContract : 安合花园 (房间号:202)房东已经确认签约成功
         * messageID : 799d2fb1-1e48-4fc1-97bd-2e9ce00d730b
         * messageTitle : 安合花园 (房间号:202)房东已经确认签约成功
         * messageType : 1
         * other :
         * payType : 0
         * pay_status : 1
         * phone : 13068893276
         * power :
         * rent :
         * roomId : U26tuxQP
         * roomRentId :
         * signId :
         * type : 5
         * water :
         * widoutTradeMoney :
         * widoutTradeNo :
         */

        private String cellReaded;
        private String createTime;
        private String deposit;
        private String id;
        private String messageContract;
        private String messageID;
        private String messageTitle;
        private String messageType;
        private String other;
        private String payType;
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

        public String getDeposit() {
            return deposit;
        }

        public void setDeposit(String deposit) {
            this.deposit = deposit;
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

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
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

    public static class NoOverLandLordNewBean {
        /**
         * cellReaded : 0
         * createTime : 2019-03-04 17:27:08
         * deposit :
         * id : feecf8a8-7961-472f-91ba-54490fe8b260
         * messageContract : 房东已经同意了您的签约申请，请缴费完成签约。需支付3960.0元
         * messageID : feecf8a8-7961-472f-91ba-54490fe8b260
         * messageTitle : 房东已经同意了您的签约申请，请缴费完成签约
         * messageType : 0
         * other :
         * payType : 0
         * pay_status : 0
         * phone : 13068893276
         * power :
         * rent :
         * roomId : Eq9abSum
         * roomRentId :
         * signId : d001325f-ddb3-4e44-9be0-fd8cfca3125a
         * type : 5
         * water :
         * widoutTradeMoney : 3960.0
         * widoutTradeNo : 6f93fe9b-7e6f-43aa-933a-177e15863732
         */

        private String cellReaded;
        private String createTime;
        private String deposit;
        private String id;
        private String messageContract;
        private String messageID;
        private String messageTitle;
        private String messageType;
        private String other;
        private String payType;
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

        public String getDeposit() {
            return deposit;
        }

        public void setDeposit(String deposit) {
            this.deposit = deposit;
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

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
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
