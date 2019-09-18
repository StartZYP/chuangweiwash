package com.startzyp.chuangweiwash.chuangweiwash.mapper.login;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @Author: Startzyp
 * @Date: 2019/9/17 17:10
 */
public interface PermissionMapper {

    @Select("SELECT\n" +
            "            u.id              userId,\n" +
            "            u.nickname        nickname,\n" +
            "            u.role_id         roleId,\n" +
            "            r.role_name       roleName,\n" +
            "            p.menu_code       menuCode,\n" +
            "            p.permission_code permissionCode\n" +
            "        FROM sys_user u\n" +
            "                 LEFT JOIN sys_role r ON r.id = u.role_id\n" +
            "                 LEFT JOIN sys_role_permission rp ON u.role_id = rp.role_id\n" +
            "                 LEFT JOIN sys_permission p ON rp.permission_id = p.id AND rp.delete_status = '1'\n" +
            "        WHERE u.username = #{username}\n" +
            "          AND u.delete_status = '1'")
    JSONObject getUserPermission(String username);


    /**
     * 查询所有的菜单
     */
    @Select("SELECT p.permission_code permissionCode\n" +
            "        FROM sys_permission p\n" +
            "        ORDER BY p.id")
    Set<String> getAllMenu();

    /**
     * 查询所有的权限
     */
    @Select("SELECT p.menu_code menuCode\n" +
            "        FROM sys_permission p\n" +
            "        ORDER BY p.id")
    Set<String> getAllPermission();

}
