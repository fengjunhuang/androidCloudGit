package com.cloudtenant.yunmenkeji.cloudtenant.bean;

public class FgMessage {
    private String Family;
    private int icon;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public FgMessage(String family, int icon) {

        Family = family;
        this.icon = icon;
    }

    public FgMessage(String family) {
        Family = family;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }
}
