package com.startzyp.chuangweiwash.chuangweiwash.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.startzyp.chuangweiwash.chuangweiwash.entity.system.ErrorMessage;
import com.startzyp.chuangweiwash.chuangweiwash.mapper.login.LoginMapper;
import com.startzyp.chuangweiwash.chuangweiwash.mapper.login.PermissionMapper;
import com.startzyp.chuangweiwash.chuangweiwash.service.LoginService;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.systemexception.LogicException;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Startzyp
 * @Date: 2019/9/16 10:09
 */
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public JSONObject authLogin(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        Subject currentUser = SecurityUtils.getSubject();
        JSONObject info = new JSONObject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            info.put("result", "success");
        } catch (UnknownAccountException e){
            throw LogicException.le(ErrorMessage.NOT_USERNAME);
        }catch (IncorrectCredentialsException e){
            throw LogicException.le(ErrorMessage.NOT_PASSWORD);
        } finally {
            info.put("result", "fail");
        }
        return info;
    }

    @Override
    public JSONObject getUser(String username, String password) {
        return loginMapper.getUser(username, password);
    }
    @Override
    public JSONObject getInfo() {
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        JSONObject info = new JSONObject();
        JSONObject userPermission = permissionMapper.getUserPermission(username);
        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
        info.put("userPermission", userPermission);
        return info;
    }

    @Override
    public JSONObject logout() {
        return null;
    }
}
