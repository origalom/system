package cn.springhub.exception;

import cn.springhub.constant.Code;

/**
 *  断言失败异常
 * @author  A.I.
 * @date   2019/11/28 17:17
 * @version   1.0
 **/
public class AssertFailedException extends SystemException {
    public AssertFailedException(Code code) {
        super(code);
    }

    public AssertFailedException(String message, Code code) {
        super(message, code);
    }

    public AssertFailedException(String message, Throwable cause, Code code) {
        super(message, cause, code);
    }

    public AssertFailedException(Throwable cause, Code code) {
        super(cause, code);
    }

    public AssertFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Code code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }
}
