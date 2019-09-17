package com.startzyp.chuangweiwash.chuangweiwash.config.shiro;


import com.alibaba.fastjson.JSONObject;
import com.startzyp.chuangweiwash.chuangweiwash.service.LoginService;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private LoginService loginService;

    //执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");
        return null;
    }

    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        /*
        * 编写shiro判断逻辑
        * */
        UsernamePasswordToken Token = (UsernamePasswordToken) authenticationToken;
        String loginName = (String) Token.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) Token.getCredentials());
        JSONObject user = loginService.getUser(loginName, password);

        if (user==null){
            //返回用户名不存在直接空就行
            throw new UnknownAccountException();
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getString("username"),
                user.getString("password"),
                //ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                getName()
        );
        //session中不需要保存密码
        user.remove("password");
        //将用户信息放入session中 如果用redis在此处存储redis中
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);

        return authenticationInfo;
    }
}
