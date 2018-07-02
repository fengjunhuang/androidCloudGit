package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MessageSave extends BaseBean{


    /**
     * id : 22
     * viewData : [{"messageRoomName":"东圃明珠新村6栋201","messageRoomID":"13123123123123123123","messageLandlordPhone":"13800138000","messageArray":[{"messageNotice":"今晚8am-9pm停电","messageWarningTime":"2018-09-12 07:22:22","messageWarningStatus":1},{"messageNotice":"22222222","messageWarningTime":"2018-09-12 22:22:22","messageWarningStatus":1}]},{"messageRoomName":"东圃明珠新村6栋205","messageRoomID":"4234543534534123123","messageLandlordPhone":"18665710271","messageArray":[{"messageNotice":"今晚送西瓜","messageWarningTime":"2018-09-12 18:22:22","messageWarningStatus":1},{"messageNotice":"3333333333","messageWarningTime":"2018-09-12 22:22:22","messageWarningStatus":0}]}]
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

        return  JSON.parseArray(getViewData(),MessageSave.ViewDataBean.class);

    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        /**
         * messageRoomName : 东圃明珠新村6栋201
         * messageRoomID : 13123123123123123123
         * messageLandlordPhone : 13800138000
         * messageArray : [{"messageNotice":"今晚8am-9pm停电","messageWarningTime":"2018-09-12 07:22:22","messageWarningStatus":1},{"messageNotice":"22222222","messageWarningTime":"2018-09-12 22:22:22","messageWarningStatus":1}]
         */

        private String messageRoomName;
        private String messageRoomID;
        private String messageLandlordPhone;
        private List<MessageArrayBean> messageArray;

        public String getMessageRoomName() {
            return messageRoomName;
        }

        public void setMessageRoomName(String messageRoomName) {
            this.messageRoomName = messageRoomName;
        }

        public String getMessageRoomID() {
            return messageRoomID;
        }

        public void setMessageRoomID(String messageRoomID) {
            this.messageRoomID = messageRoomID;
        }

        public String getMessageLandlordPhone() {
            return messageLandlordPhone;
        }

        public void setMessageLandlordPhone(String messageLandlordPhone) {
            this.messageLandlordPhone = messageLandlordPhone;
        }

        public List<MessageArrayBean> getMessageArray() {
            return messageArray;
        }

        public void setMessageArray(List<MessageArrayBean> messageArray) {
            this.messageArray = messageArray;
        }

        public static class MessageArrayBean {
            /**
             * messageNotice : 今晚8am-9pm停电
             * messageWarningTime : 2018-09-12 07:22:22
             * messageWarningStatus : 1
             */

            private String messageNotice;
            private String messageWarningTime;
            private int messageWarningStatus;

            public String getMessageNotice() {
                return messageNotice;
            }

            public void setMessageNotice(String messageNotice) {
                this.messageNotice = messageNotice;
            }

            public String getMessageWarningTime() {
                return messageWarningTime;
            }

            public void setMessageWarningTime(String messageWarningTime) {
                this.messageWarningTime = messageWarningTime;
            }

            public int getMessageWarningStatus() {
                return messageWarningStatus;
            }

            public void setMessageWarningStatus(int messageWarningStatus) {
                this.messageWarningStatus = messageWarningStatus;
            }
        }
    }
}
