package com.ruoyi.system.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.utils.HttpUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/object/open")
public class OpenController {

    @Autowired
    private WeixinProperties weixinProperties;

    OpenController(WeixinProperties weixinProperties){
        this.weixinProperties = weixinProperties;
    }

    /**
     * 获取微信小程序端openId
     * @return
     */
    @Anonymous
    @PostMapping("/getOpenId")
    public String getOpenId(@RequestBody LoginRequest request) {
        System.out.println(weixinProperties.toString());
        HttpResponse response = null;
        MyWeixin myWeixin = new MyWeixin();
        try {
            response = HttpUtils.doGet("https://api.weixin.qq.com",
                    "/sns/jscode2session?appid="+weixinProperties.getAppid()+"&secret="+weixinProperties.getSecret()+"&js_code=" + request.getCode() + "&grant_type=authorization_code",
                    "get",
                    new HashMap<String,String>(),
                    null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response.getStatusLine().getStatusCode() == 200) {
            String s = null;
            try {
                s = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            myWeixin = JSON.parseObject(s, MyWeixin.class);
            System.out.println(myWeixin.toString());
        }

        return myWeixin.getOpenId();
    }


    /**
     * 获取微信小程序端Phone
     */
    @Anonymous
    @PostMapping("/getPhone")
    public String getMsg(@RequestBody LoginRequest request) {
        String accessToken = getAccessToken();
        System.out.println("code:" + request.getCode());
        System.out.println("token:" + accessToken);
        HashMap<String,String> body = new HashMap<String,String>();
        body.put("code", request.getCode());
        HashMap<String,String> header = new HashMap<String, String>();
        HttpResponse response = null;
        WxPhone wxPhone = new WxPhone();
        try {
            response = HttpUtils.doPost("https://api.weixin.qq.com",
                    "/wxa/business/getuserphonenumber?access_token="+accessToken,
                    "post",
                    new HashMap<String, String>(),
                    body,
                    new HashMap<String,String>());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response.getStatusLine().getStatusCode() == 200) {
            String s = null;
            try {
                s = EntityUtils.toString(response.getEntity());
                System.out.println("1111111111112"+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wxPhone = JSON.parseObject(s, WxPhone.class);
            System.out.println(wxPhone.toString());
        }

        return wxPhone.getPhoneNumber();
    }

    public String getAccessToken(){
        HttpResponse responses = null;
        Weixin wx = new Weixin();
        Map<String,String> header = new HashMap<>();
        System.out.println("wexin=>"+weixinProperties.toString());
        header.put("grant_type", "client_credential");
        header.put("appid",weixinProperties.getAppid());
        header.put("secret",weixinProperties.getSecret());
        JSONObject json = new JSONObject(header);
        for (Map.Entry<String,String> body : header.entrySet()) {
            String key = body.getKey();
            String value = body.getValue();
            System.out.println("键:" + key + ",值:" + value);
        }
        try {
            responses = HttpUtils.doGet("https://api.weixin.qq.com",
                    "/cgi-bin/token",
                    "post",
                    header,
                    new HashMap<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (responses.getStatusLine().getStatusCode() == 200) {
            String s = null;
            try {
                s = EntityUtils.toString(responses.getEntity());
                System.out.println("111111111111111"+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wx = JSON.parseObject(s, Weixin.class);
            System.out.println(wx.toString());
        }
        return wx.getAccess_token();
    }

    /**
     * 获取微信小程序端sessionKey
     */
    @Anonymous
    @PostMapping("/getSessionKey")
    public String getSessionKey(@RequestBody LoginRequest request){
        HttpResponse responses = null;
        MyWeixin wx = new MyWeixin();
        String jsCode = request.getCode();
        Map<String,String> header = new HashMap<>();
        System.out.println("wexin=>"+weixinProperties.toString());
        header.put("grant_type", "authorization_code");
        header.put("appid",weixinProperties.getAppid());
        header.put("secret",weixinProperties.getSecret());
        header.put("js_code",jsCode);
        JSONObject json = new JSONObject(header);
        for (Map.Entry<String,String> body : header.entrySet()) {
            String key = body.getKey();
            String value = body.getValue();
            System.out.println("键:" + key + ",值:" + value);
        }
        System.out.println("jsCode=>"+jsCode);
        try {
            responses = HttpUtils.doGet("https://api.weixin.qq.com",
                    "/sns/jscode2session",
                    "get",
                    new HashMap<>(),
                    header
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (responses.getStatusLine().getStatusCode() == 200) {
            String s = null;
            try {
                s = EntityUtils.toString(responses.getEntity());
                System.out.println("111111111111111"+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wx = JSON.parseObject(s, MyWeixin.class);
            System.out.println(wx.toString());
        }
        return wx.getSession_key();
    }
}
