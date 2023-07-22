package com.ruoyi.system.domain;

/**
 * @Author:cy
 * @Date:2023/7/20
 */
public class WxPhone {
    String phoneNumber;

    @Override
    public String toString() {
        return "WxPhone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
