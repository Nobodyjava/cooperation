package com.ruoyi.system.domain;

public class LoginRequest {
    private String code;

    public LoginRequest() {
    }

    public LoginRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "code='" + code + '\'' +
                '}';
    }
}
