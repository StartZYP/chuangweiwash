package com.startzyp.chuangweiwash.chuangweiwash.systemmodel.systemexception;

/**
 * @author startzyp
 * 业务逻辑异常类
 */
public class LogicException extends RuntimeException {
    /**
     * 异常信息
     */
    private String errorMsg;
    /**
     * 错误码
     */
    private String code;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private LogicException(String errorMsg) {
        super(errorMsg);
        this.code = errorMsg.substring(0, 5);
        this.errorMsg = errorMsg.substring(6);
    }

    /**
     * 抛出逻辑异常
     *
     * @param errorMsg
     * @return
     */
    public static LogicException le(String errorMsg) {
        return new LogicException(errorMsg);
    }
}