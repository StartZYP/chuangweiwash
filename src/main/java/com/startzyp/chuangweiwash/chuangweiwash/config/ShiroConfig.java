package com.startzyp.chuangweiwash.chuangweiwash.config;

import com.startzyp.chuangweiwash.chuangweiwash.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /*
    创建getShiroFilterFactoryBean1
    * */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro过滤器
        /*
         * Shiro内置过滤器可以实现权限的拦截
         *       常用的过滤器
         *           anon:   无需认证谁都可以访问
         *           authc:  必须认证才可以访问
         *           user:   如果使用rememberMe的功能可以直接访问
         *           perms:  该资源必须得到资源权限才可以访问
         *           role:   该资源必须得到角色权限才可以访问
         * */
        Map<String,String> ShiroFilterMap = new LinkedHashMap<>();
        ShiroFilterMap.put("/index","authc");
        ShiroFilterMap.put("/user","authc");
        ShiroFilterMap.put("/log","authc");
        //修改跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(ShiroFilterMap);
        return shiroFilterFactoryBean;
    }

    /*创建DefaultWebSecurityManger
     *
     * */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("UserRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    /*创建Realm
     *
     * */
    @Bean(name = "UserRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}