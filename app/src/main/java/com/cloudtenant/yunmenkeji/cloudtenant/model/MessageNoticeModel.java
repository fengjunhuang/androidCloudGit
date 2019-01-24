package com.cloudtenant.yunmenkeji.cloudtenant.model;

import java.io.Serializable;
import java.util.List;

public class MessageNoticeModel extends BaseBean {

    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean implements Serializable {

        private String messageBuildingName;
        private String messageBuildingID;
        private String messageLandlordPhone;

        private List<MyRoomSensorListBean> messageArray;

        public String getMessageBuildingName() {
            return messageBuildingName;
        }

        public void setMessageBuildingName(String messageBuildingName) {
            this.messageBuildingName = messageBuildingName;
        }

        public String getMessageBuildingID() {
            return messageBuildingID;
        }

        public void setMessageBuildingID(String messageBuildingID) {
            this.messageBuildingID = messageBuildingID;
        }

        public String getMessageLandlordPhone() {
            return messageLandlordPhone;
        }

        public void setMessageLandlordPhone(String messageLandlordPhone) {
            this.messageLandlordPhone = messageLandlordPhone;
        }

        public List<MyRoomSensorListBean> getMessageArray() {
            return messageArray;
        }

        public void setMessageArray(List<MyRoomSensorListBean> messageArray) {
            this.messageArray = messageArray;
        }

        public static class MyRoomSensorListBean implements Serializable {
            /**
             * sensorID : 123456
             * sensorName : 室内多功能集成传感器
             * sensorOn : fasle
             */

            private String messageNotice;
            private String messageWarningStatus;
            private String messageWarningTime;

            public String getMessageNotice() {
                return messageNotice;
            }

            public void setMessageNotice(String messageNotice) {
                this.messageNotice = messageNotice;
            }

            public String getMessageWarningStatus() {
                return messageWarningStatus;
            }

            public void setMessageWarningStatus(String messageWarningStatus) {
                this.messageWarningStatus = messageWarningStatus;
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
