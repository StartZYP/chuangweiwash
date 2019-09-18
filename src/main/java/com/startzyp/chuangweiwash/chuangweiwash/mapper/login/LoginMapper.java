package com.startzyp.chuangweiwash.chuangweiwash.mapper.login;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Startzyp
 * @Date: 2019/9/17 10:12
 */
public interface LoginMapper {
    @Select("SELECT\n" +
            "            u.id       userId,\n" +
            "            u.username username,\n" +
            "            u.password password,\n" +
            "            u.nickname nickName\n" +
            "        FROM\n" +
            "            sys_user u\n" +
            "        WHERE u.username = #{username}\n" +
            "          AND u.password = #{password}\n" +
            "          AND u.delete_status = '1'")
    JSONObject getUser(String username,String password);
}
