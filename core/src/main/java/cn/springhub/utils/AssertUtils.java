package cn.springhub.utils;

import cn.springhub.constant.Code;
import cn.springhub.exception.AssertFailedException;

/**
 *  断言工具类，断言失败会抛出异常
 * @author  A.I.
 * @date   2019/11/28 16:59
 * @version   1.0
 **/
public class AssertUtils {

    private AssertUtils() {}

    /**
     *  断言参数为null
     * @param obj
     */
    public static void isNotNull(Object obj) {
        if(obj == null) {
            assertFailed("参数[" + obj + "]不为空" , null);
        }
    }


    protected static void assertFailed(String message, AssertFailedException exception) {
        if(exception == null) {
            // 异常为空时，自定义一个参数异常
            exception = new AssertFailedException(message, Code.PARAMS_ASSERT_ERROR);
        }

        throw exception;
    }
}
