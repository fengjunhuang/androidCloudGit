
package com.cloudtenant.yunmenkeji.cloudtenant.model;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.BaseBeanC;

public class SensorCycleModel extends BaseBeanC {

    private int status;
    private String startTime;
    private String endTime;
    private String cycleDate;
    private String modeName;
    private String ids;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCycleDate() {
        return cycleDate;
    }

    public void setCycleDate(String cycleDate) {
        this.cycleDate = cycleDate;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
