package com.startzyp.chuangweiwash.chuangweiwash.systemmodel.util;

/**
 * @Author: Startzyp
 * @Date: 2019/9/16 21:01
 */
public class StringTools {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}