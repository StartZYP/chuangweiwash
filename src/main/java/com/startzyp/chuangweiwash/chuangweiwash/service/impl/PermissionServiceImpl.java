package com.startzyp.chuangweiwash.chuangweiwash.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.startzyp.chuangweiwash.chuangweiwash.mapper.login.PermissionMapper;
import com.startzyp.chuangweiwash.chuangweiwash.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: Startzyp
 * @Date: 2019/9/17 17:09
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 查询某用户的 角色  菜单列表   权限列表
     */
    @Override
    public JSONObject getUserPermission(String username) {
        JSONObject userPermission = getUserPermissionFromDB(username);
        return userPermission;
    }

    /**
     * 从数据库查询用户权限信息
     */
    private JSONObject getUserPermissionFromDB(String username) {
        JSONObject userPermission = permissionMapper.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
            //查询所有菜单  所有权限
            Set<String> menuList = permissionMapper.getAllMenu();
            Set<String> permissionList = permissionMapper.getAllPermission();
            userPermission.put("menuList", menuList);
            userPermission.put("permissionList", permissionList);
        }
        return userPermission;
    }
}