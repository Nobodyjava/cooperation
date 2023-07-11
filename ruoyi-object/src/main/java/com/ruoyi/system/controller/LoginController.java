package com.ruoyi.system.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/object/login")
public class LoginController {

    @Anonymous
    @PostMapping()
    public AjaxResult testLogin(HttpServletRequest request) throws ServletException {
        // 接受前端传过来的电话和密码
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        if ("123".equals(phone) && "password".equals(password)) {

        }else {
            throw new ServletException("登录失败!!!");
        }
        return AjaxResult.success();
    }
}
