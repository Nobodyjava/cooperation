package com.ruoyi.system.domain;

/**
 * @program:
 * @description:
 * @create: 2023-07-27 16:40
 **/
public class WxEncryptedData {
    private String encryptedData;
    private String iv;
    private String sessionKey;

    public WxEncryptedData() {
    }

    @Override
    public String toString() {
        return "WxEncryptedData{" +
                "encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
