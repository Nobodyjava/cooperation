package com.ruoyi.system.controller;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.system.domain.LoginRequest;
import com.ruoyi.system.domain.MyWeixin;
import com.ruoyi.system.domain.WeixinProperties;
import com.ruoyi.system.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

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
    public String getMsg(@RequestBody LoginRequest request) {
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

}
