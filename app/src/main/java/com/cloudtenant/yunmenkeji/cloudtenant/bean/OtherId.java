package com.cloudtenant.yunmenkeji.cloudtenant.bean;

public class OtherId {
    private String num;
    private String name;
    private String phone;
    private String fImage;
    private String bImage;

    public OtherId(String num, String name, String phone, String fImage, String bImage) {
        this.num = num;
        this.name = name;
        this.phone = phone;
        this.fImage = fImage;
        this.bImage = bImage;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getfImage() {
        return fImage;
    }

    public void setfImage(String fImage) {
        this.fImage = fImage;
    }

    public String getbImage() {
        return bImage;
    }

    public void setbImage(String bImage) {
        this.bImage = bImage;
    }

    @Override
    public String toString() {
        return "OtherId{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", fImage='" + fImage + '\'' +
                ", bImage='" + bImage + '\'' +
                '}';
    }
}
