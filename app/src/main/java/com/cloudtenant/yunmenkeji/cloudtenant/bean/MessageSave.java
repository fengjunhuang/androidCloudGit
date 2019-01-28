package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MessageSave extends BaseBean{


    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean {
        /**
         * messageArray : [{"messageNotice":"祝大家元旦快乐","messageWarningTime":"2018-12-25 14:14:00.0"}]
         * messageBuildingID : 1542018947617
         * messageBuildingName : 绿地越秀·海玥
         * messageLandlordPhone : 13800138000
         */

        private String messageBuildingID;
        private String messageBuildingName;
        private String messageLandlordPhone;
        private List<MessageArrayBean> messageArray;

        public String getMessageBuildingID() {
            return messageBuildingID;
        }

        public void setMessageBuildingID(String messageBuildingID) {
            this.messageBuildingID = messageBuildingID;
        }

        public String getMessageBuildingName() {
            return messageBuildingName;
        }

        public void setMessageBuildingName(String messageBuildingName) {
            this.messageBuildingName = messageBuildingName;
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
             * messageNotice : 祝大家元旦快乐
             * messageWarningTime : 2018-12-25 14:14:00.0
             */

            private String messageNotice;
            private String messageWarningTime;

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
        }
    }
}
