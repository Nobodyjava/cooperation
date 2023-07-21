package com.ruoyi.system.domain;

/**
 * 微信实体类
 */
public class MyWeixin {
    String session_key = "";
    private String openId = "";

    public MyWeixin() {
    }

    public MyWeixin(String session_key, String openId) {
        this.session_key = session_key;
        this.openId = openId;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
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
                "session_key='" + session_key + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}

