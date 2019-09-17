package com.startzyp.chuangweiwash.chuangweiwash.controller.logincontroller;

import com.alibaba.fastjson.JSONObject;
import com.startzyp.chuangweiwash.chuangweiwash.entity.system.ErrorMessage;
import com.startzyp.chuangweiwash.chuangweiwash.service.LoginService;
import com.startzyp.chuangweiwash.chuangweiwash.service.impl.LoginServiceImpl;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.systemexception.LogicException;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户登录操作", description = "用户登录 API", position = 100, protocols = "http")
public class userlogin {

    @Autowired
    private LoginService loginService;

    @ApiOperation("用户登录接口")
    @PostMapping(value = "/login")
    public JSONObject userLoginSystem(@RequestBody JSONObject requestJson){

        CommonUtil.hasAllRequired(requestJson, "username,password");
        /*
         * 使用Shiro编写认证
         * */
        //1.获取subject

        return loginService.authLogin(requestJson);
    }

    /**
     * 查询当前登录用户的信息
     */
    @ApiOperation("查询用户信息接口")
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     */
    @ApiOperation("登出接口")
    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }

}
