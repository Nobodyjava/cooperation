package com.ruoyi.system.domain;

public class Weixin {

    private String access_token;
    private String phone;

    @Override
    public String toString() {
        return "Weixin{" +
                "access_token='" + access_token + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
