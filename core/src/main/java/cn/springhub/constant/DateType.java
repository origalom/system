package cn.springhub.constant;

import cn.springhub.exception.SystemException;
import cn.springhub.utils.RegexUtils;
import cn.springhub.utils.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  日期类型常量
 * @author  A.I.
 * @date   2019/11/28 16:16
 * @version   1.0
 **/
public enum DateType implements Constant<String> {

    DATE_TIME("yyyy-MM-dd HH:mm:ss", "正常时间格式")
    , DATE("yyyy-MM-dd", "日期格式")
    , TIME("HH:mm:ss", "时间格式")
    , DATE_TIMESTAMP("yyyy-MM-dd HH:mm:ss.SSS", "带有毫秒的时间格式")
    , DATE_TIME_WITHOUT_OTHERS("yyyyMMddHHmmss", "只有数字的时间格式")
    , DATE_TIME_WITH_DIAGONAL("yyyy/MM/dd HH:mm:ss", "斜杆格式的时间")
    , DATE_WITH_DIAGONAL("yyyy-MM-dd", "斜杆格式的日期")
    , DATE_TIME_WITH_CHINESE("yyyy年MM月dd日HH时mm分ss秒", "中文格式时间")
    , DATE_WITH_CHINESE("yyyy年MM月dd日", "中文格式日期")
    , TIME_WITH_CHINESE("HH时mm分ss秒", "中文格式时间")
    ;

    /**
     *  将时间转换成字符串格式
     * @param date  时间
     * @return
     */
    public String convertDateToString(Date date) {
        if(date == null) {
            return null;
        }

        return dateFormat.format(date);
    }

    /**
     *  将字符串转换成时间格式
     * @param date  时间字符串
     * @return
     */
    public Date convertStringToDate(String date) {
        if(StringUtils.isEmpty(date)) {
            return null;
        }

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new SystemException("日期字符串：\"" + date + "\"转换成日期失败，不符合指定的日期格式[" + getValue() + "]", e, Code.PARMAS_TYPE_ERROR);
        }
    }

    /**
     *  判断时间是否满足指定的格式
     * @param date
     * @return
     */
    public boolean isRegexDate(String date) {
        return RegexUtils.isMatching(date, getValue());
    }

    private String dateType;

    private String desc;

    protected DateFormat dateFormat;

    DateType(String dateType, String desc) {
        this.dateType = dateType;
        this.desc = desc;
        this.dateFormat = new SimpleDateFormat(dateType);
    }

    @Override
    public String getValue() {
        return dateType;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
