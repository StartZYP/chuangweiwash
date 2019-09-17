package com.startzyp.chuangweiwash.chuangweiwash.entity.system;

/**
 * @author startzyp
 * 错误提示集合类
 * 错误码构成：   01程序员编号
 * 001该程序员定义的错误码
 * 后面再跟上错误信息
 */
public final class ErrorMessage {
    public static final String SYSTEM_EXCEPTION = "系统繁忙，请稍后再试";
    public static final String NOT_USERNAME = "01001_用户名不存在";
    public static final String NOT_PASSWORD = "01002_密码错误";
    public static final String NOT_LOGIN = "01003_您还未登陆或者登陆已超时，请重新登陆";
    public static final String NOT_FIELDINPUT = "01004_您有未填写的字段,表单提交失败";
    public static final String LOGIC_EXCEPTION = "01003_对不起，你是真的没有我帅";
}