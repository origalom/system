package cn.springhub.exception;

import cn.springhub.constant.Code;

/**
 *  系统自定义异常
 * @author  A.I.
 * @date   2019/11/27 13:44
 * @version   1.0
 **/
public class SystemException extends RuntimeException {

    protected Code code;

    public SystemException(Code code) {
        this.code = code;
    }

    public SystemException(String message, Code code) {
        super(message);
        this.code = code;
    }

    public SystemException(String message, Throwable cause, Code code) {
        super(message, cause);
        this.code = code;
    }

    public SystemException(Throwable cause, Code code) {
        super(cause);
        this.code = code;
    }

    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Code code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
