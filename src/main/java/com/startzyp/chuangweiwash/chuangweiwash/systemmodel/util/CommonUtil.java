package com.startzyp.chuangweiwash.chuangweiwash.systemmodel.util;

import com.alibaba.fastjson.JSONObject;
import com.startzyp.chuangweiwash.chuangweiwash.entity.system.ErrorMessage;
import com.startzyp.chuangweiwash.chuangweiwash.systemmodel.systemexception.LogicException;

/**
 * @Author: Startzyp
 * @Date: 2019/9/16 20:59
 */
public class CommonUtil {

    /**
     * 验证是否含有全部必填字段
     *
     * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
     */
    public static void hasAllRequired(final JSONObject jsonObject, String requiredColumns) {
        if (!StringTools.isNullOrEmpty(requiredColumns)) {
            //验证字段非空
            String[] columns = requiredColumns.split(",");
            String missCol = "";
            for (String column : columns) {
                Object val = jsonObject.get(column.trim());
                if (StringTools.isNullOrEmpty(val)) {
                    missCol += column + "  ";
                }
            }
            if (!StringTools.isNullOrEmpty(missCol)) {
                throw LogicException.le(ErrorMessage.NOT_FIELDINPUT);
            }
        }
    }
}
