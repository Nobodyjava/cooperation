package com.ruoyi.system.domain;

public class Weixin {

    private String accessToken;
    private String phone;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Weixin{" +
                "accessToken='" + accessToken + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
