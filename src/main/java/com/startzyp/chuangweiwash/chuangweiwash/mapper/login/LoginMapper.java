package com.startzyp.chuangweiwash.chuangweiwash.mapper.login;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Startzyp
 * @Date: 2019/9/17 10:12
 */
public interface LoginMapper {
    @Select("select * from awardItem")
    JSONObject getUser(String username,String password);
}
