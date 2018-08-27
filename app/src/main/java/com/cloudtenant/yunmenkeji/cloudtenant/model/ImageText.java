package com.cloudtenant.yunmenkeji.cloudtenant.model;

/**
 * Created by 72984 on 2018/7/3.
 */

public class ImageText {
    private String text;
    private boolean isSelect;

    public ImageText(String text, boolean isSelect) {
        this.text = text;
        this.isSelect = isSelect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
