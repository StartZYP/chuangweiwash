package com.startzyp.chuangweiwash.chuangweiwash.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户登录操作", description = "用户登录 API", position = 100, protocols = "http")
public class userlogin {

    @ApiOperation("用户登录接口")
    @PostMapping(value = "/login")
    public String userOpenWashingMachine(String user){
        System.out.println("hehe");
        return user;
    }
}
