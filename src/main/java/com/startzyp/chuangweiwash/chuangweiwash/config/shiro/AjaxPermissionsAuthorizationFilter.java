package com.startzyp.chuangweiwash.chuangweiwash.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.startzyp.chuangweiwash.chuangweiwash.entity.system.ErrorMessage;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.restresult.RestResult;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/*
*
* 新增Shiro全局未授权拦截
* */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            RestResult noLogin = new RestResult(false, "01001", "NoLogin", ErrorMessage.NOT_LOGIN);
            out.println(JSONObject.toJSON(noLogin));
        } catch (Exception e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }

        return false;
    }

    @Bean
    public FilterRegistrationBean<AjaxPermissionsAuthorizationFilter> registration(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean<AjaxPermissionsAuthorizationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}
