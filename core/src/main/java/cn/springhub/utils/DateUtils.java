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

    /**
     *  获取当前时间字符串
     * @return
     */
    public static String getCurrentDate() {
        return getDate(new Date(), DateType.DATE_TIME);
    }

    /**
     *  将时间字符串转换成时间格式
     * @param date  时间字符串
     * @param dateType  时间格式
     * @return
     */
    public static Date getDate(String date, DateType dateType) {
        return dateType.convertStringToDate(date);
    }

}
