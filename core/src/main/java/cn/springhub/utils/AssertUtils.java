package cn.springhub.utils;

import cn.springhub.constant.Code;
import cn.springhub.constant.Regex;
import cn.springhub.constant.SystemConstant;
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
    public static void isNotNull(Object obj, String mmessage) {
        if(obj == null) {
            assertFailed(mmessage);
        }
    }

    /**
     *  断言数组长度
     * @param array 数组
     * @param length    长度
     */
    public static void arrayLengthIsTrue(Object[] array, int length, String message) {
        if(array == null || array.length != length) {
            assertFailed(message);
        }
    }

    /**
     *  判断数据是整数
     * @param obj       参数
     */
    public static void isNumber(Object obj, String message) {
        isNotNull(obj, message);

        if(obj instanceof Integer) {
            return;
        }

        if(!RegexUtils.isMatching(obj.toString(), Regex.POSITIVE_INTEGER.getValue())) {
            assertFailed(message);
        }
    }

    /**
     *  统一异常抛出
     * @param message
     */
    protected static void assertFailed(String message) {
        AssertFailedException exception;
        // 查看本地是否存在定义的异常
        Object obj = Locale.get(SystemConstant.SYSTEM_ASSERT_ERROR);
        if(obj != null && obj instanceof AssertFailedException) {
            exception = (AssertFailedException) obj;
        } else {
            // 异常为空时，自定义一个参数异常
            exception = new AssertFailedException(message, Code.PARAMS_ASSERT_ERROR);
        }

        throw exception;
    }
}
