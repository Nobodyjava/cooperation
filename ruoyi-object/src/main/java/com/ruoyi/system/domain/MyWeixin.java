package com.ruoyi.system.domain;

/**
 * 微信实体类
 */
public class MyWeixin {
    /** openid */
    String openId = "";

    public MyWeixin() {
    }

    public MyWeixin(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "MyWeixin{" +
                "openId='" + openId + '\'' +
                '}';
    }
}
