package com.xueyou.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xueyou.ssm.serviceimpl.LoginService;

/**
 * Created by wuxueyou on 16/10/1.
 */
//@RestController
@Controller
@RequestMapping(value = "/login" , method = {RequestMethod.GET,RequestMethod.POST}, produces = "application/json;charset=UTF-8;")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/ssmlogin")
    public Map<String,Object> ssmLogin(String username,String password){
        Map<String,Object> params = new HashMap<>();
        System.out.println(username);
        System.out.println(password);
        params.put("username",username);
        params.put("password",password);
        return loginService.login(params);
    }
}
