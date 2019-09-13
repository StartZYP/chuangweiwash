package com.startzyp.chuangweiwash.chuangweiwash.controller.usercontrooler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户操作", description = "用户 API", position = 100, protocols = "http")
public class user {

    @ApiOperation("用户信息")
    @GetMapping(value = "/UserInfo")
    public String getUser(String user){
        System.out.println("hehe");
        return user;
    }


    @ApiOperation("开启机器")
    @PostMapping(value = "/OpenMachine")
    public String userOpenWashingMachine(String user){
        System.out.println("hehe");
        return user;
    }

    @ApiOperation("查看自己洗衣机器记录")
    @GetMapping(value = "/LookLog")
    public String LookWashingMachineLog(String user){
        System.out.println("hehe");
        return user;
    }


}
