package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class RoomMessageHistory extends BaseBean{


    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean {
        /**
         * sensorId : 客卧室
         * sensorModel : 客卧室
         * status : 客卧室
         * position : 客卧室
         * positionId : 2
         * sensorBodyMessage : [{"body":"1","createTime":"2019-02-26 00:08:52","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1551110939377},{"body":"1","createTime":"2019-02-25 09:47:06","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1551059186545},{"body":"1","createTime":"2019-02-25 01:11:56","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1551028309589},{"body":"1","createTime":"2019-02-24 17:54:07","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1551002047473},{"body":"1","createTime":"2019-02-24 08:48:27","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550969298817},{"body":"1","createTime":"2019-02-20 01:48:43","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550598505313},{"body":"1","createTime":"2019-02-20 01:37:52","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550597881421},{"body":"1","createTime":"2019-02-20 01:32:22","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550597552588},{"body":"1","createTime":"2019-02-19 16:18:31","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550564308175},{"body":"1","createTime":"2019-02-19 16:16:41","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550564200545},{"body":"1","createTime":"2019-02-19 16:11:21","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550563863825},{"body":"1","createTime":"2019-02-19 15:35:20","fire":"0","sensorId":"xr4gst3xyi2012","smoke":"0","time":1550561722590}]
         */

        private String sensorId;
        private String sensorModel;
        private String status;
        private String position;
        private String positionId;
        private List<SensorBodyMessageBean> sensorBodyMessage;

        public String getSensorId() {
            return sensorId;
        }

        public void setSensorId(String sensorId) {
            this.sensorId = sensorId;
        }

        public String getSensorModel() {
            return sensorModel;
        }

        public void setSensorModel(String sensorModel) {
            this.sensorModel = sensorModel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getPositionId() {
            return positionId;
        }

        public void setPositionId(String positionId) {
            this.positionId = positionId;
        }

        public List<SensorBodyMessageBean> getSensorBodyMessage() {
            return sensorBodyMessage;
        }

        public void setSensorBodyMessage(List<SensorBodyMessageBean> sensorBodyMessage) {
            this.sensorBodyMessage = sensorBodyMessage;
        }

        public static class SensorBodyMessageBean {
            /**
             * body : 1
             * createTime : 2019-02-26 00:08:52
             * fire : 0
             * sensorId : xr4gst3xyi2012
             * smoke : 0
             * time : 1551110939377
             */

            private String body;
            private String createTime;
            private String fire;
            private String sensorId;
            private String smoke;
            private long time;

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFire() {
                return fire;
            }

            public void setFire(String fire) {
                this.fire = fire;
            }

            public String getSensorId() {
                return sensorId;
            }

            public void setSensorId(String sensorId) {
                this.sensorId = sensorId;
            }

            public String getSmoke() {
                return smoke;
            }

            public void setSmoke(String smoke) {
                this.smoke = smoke;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }
        }
    }
}
