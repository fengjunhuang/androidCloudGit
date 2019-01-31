package com.cloudtenant.yunmenkeji.cloudtenant.model;

import java.io.Serializable;
import java.util.List;

public class SensorModel extends BaseBean {


    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean  implements Serializable{
        /**
         * gateModel : TS2012
         * light : 10
         * position : 客卧室
         * positionId : 2
         * securityStatus : 2
         * sensorId : xr4gst3xyi2012
         * ten : 26
         * time : 1548825987122
         * wet : 30
         */

        private String gateModel;
        private String light;
        private String position;
        private String positionId;
        private String securityStatus;
        private String sensorId;
        private String ten;

        private double time;

        private String wet;

        public String getGateModel() {
            return gateModel;
        }

        public void setGateModel(String gateModel) {
            this.gateModel = gateModel;
        }

        public String getLight() {
            return light;
        }

        public void setLight(String light) {
            this.light = light;
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

        public String getSecurityStatus() {
            return securityStatus;
        }

        public void setSecurityStatus(String securityStatus) {
            this.securityStatus = securityStatus;
        }

        public String getSensorId() {
            return sensorId;
        }

        public void setSensorId(String sensorId) {
            this.sensorId = sensorId;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }


        public double getTime() {

            return time;
        }

        public void setTime(double time) {
            this.time = time;
        }

        public String getWet() {
            return wet;
        }

        public void setWet(String wet) {
            this.wet = wet;
        }
    }
}
