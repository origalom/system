package cn.springhub.utils;


import cn.springhub.constant.DateType;

import java.util.Date;

/**
 *  日期工具类
 * @author  A.I.
 * @date   2019/11/28 15:56
 * @version   1.0
 **/
public class DateUtils {

    private DateUtils() {}

    /**
     *  将日期转换成指定格式的字符串日期
     * @author  A.I.
     * @date   2019/11/28 16:30
     * @version   1.0
     **/
    public static String getDate(Date date, DateType dateType) {
        return dateType.convertDateToString(date);
    }

}
