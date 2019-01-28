package com.cloudtenant.yunmenkeji.cloudtenant.model;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.BaseBeanC;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;

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

    public static class ViewDataBean implements Serializable {
        private String light;
        private String position;
        private String securityStatus;
        private String gateModel;
        private String sensorId;
        private String positionId;
        private String ten;
        private int time;
        private String wet;

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

        public String getSecurityStatus() {
            return securityStatus;
        }

        public void setSecurityStatus(String securityStatus) {
            this.securityStatus = securityStatus;
        }

        public String getGateModel() {
            return gateModel;
        }

        public void setGateModel(String gateModel) {
            this.gateModel = gateModel;
        }

        public String getSensorId() {
            return sensorId;
        }

        public void setSensorId(String sensorId) {
            this.sensorId = sensorId;
        }

        public String getPositionId() {
            return positionId;
        }

        public void setPositionId(String positionId) {
            this.positionId = positionId;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
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
