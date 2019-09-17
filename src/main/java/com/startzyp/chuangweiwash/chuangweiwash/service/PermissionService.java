package com.startzyp.chuangweiwash.chuangweiwash.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Startzyp
 * @Date: 2019/9/17 17:09
 */
public interface PermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     */
    JSONObject getUserPermission(String username);
}
