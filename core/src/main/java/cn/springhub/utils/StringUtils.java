package cn.springhub.utils;

/**
 *  字符串工具类
 * @author  A.I.
 * @date   2019/11/27 13:46
 * @version   1.0
 **/
public class StringUtils {

    public static final String EMPTY = "";

    private StringUtils() {}

    /**
     *  判断字符串为空或者为null
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     *  判断字符串不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     *  判断字符串为空，空白字符串或者null
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }

        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }

        return true;
    }

    /**
     *  判断字符串不为空字符串
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     *  去除字符串前后空格
     *  主要添加当为null时的返回
     * @param str
     * @return
     */
    public static String trim(String str) {
        return str == null ? null :str.trim();
    }

    /**
     *  判断2个字符串是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    /**
     *  判断2个字符串是否相等，忽略大小写
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }

    /**
     *  查找字符串在字符中的位置
     * @param str
     * @param searchChar
     * @return
     */
    public static int indexOf(String str, String searchChar) {
        if(str == null || searchChar == null) {
            return -1;
        }

        return str.indexOf(searchChar);
    }

    /**
     *  查找字符在字符串中最后一次出现的位置
     * @param str
     * @param searchCahr
     * @return
     */
    public static int lastIndexOf(String str, String searchCahr) {
        if(searchCahr == null || str == null) {
            return -1;
        }

        return str.lastIndexOf(searchCahr);
    }

    /**
     *  判断一个字符串是否包含另一个字符串
     * @param str
     * @param searchStr
     * @return
     */
    public static boolean contains(String str, String searchStr) {
        return indexOf(str, searchStr) >= 0;
    }

    /**
     *  截取字符串
     * @param str   字符串
     * @param start 截取开始位置
     * @param end   截取结束位置
     * @return
     */
    public static String substring(String str, int start, int end) {
        if(str == null) {
            return null;
        }

        if(end < 0) {
            // 负数表示从结尾倒数
            end = str.length() + end;
        }

        if(start < 0) {
            // 负数表示从结尾倒数
            start = str.length() + start;
        }

        if(end > str.length()) {
            // 最长只能为字符串长度
            end = str.length();
        }

        if(start >= end) {
            // 开始>=结束，找不到，返回空字符串
            return EMPTY;
        }

        if(start < 0) {
            start = 0;
        }

        if(end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     *  截取字符串
     * @param str   待截取字符串
     * @param start 开始截取位置
     * @return
     */
    public static String substring(String str, int start) {
        if(str == null) {
            return null;
        }

        if(start < 0) {
            // 负数表示从结尾倒数
            start = str.length() + start;
        }

        if(start < 0) {
            start = 0;
        }

        if(start > str.length()) {
            return EMPTY;
        }

        return str.substring(start);
    }
}
