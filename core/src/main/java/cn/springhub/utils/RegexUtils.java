package cn.springhub.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  正则表达式工具类
 * @author  A.I.
 * @date   2019/11/29 16:09
 * @version   1.0
 **/
public class RegexUtils {

    private RegexUtils() {}

    /**
     *  判断字符串是否满足指定的正则表达式
     * @param str       字符串
     * @param regex   正则
     * @return
     */
    public static boolean isMatching(String str, String regex) {
        if(StringUtils.isEmpty(str) || StringUtils.isEmpty(regex)) {
            return false;
        }

        Pattern p = Pattern.compile(regex);
        Matcher matcher =  p.matcher(str);

        return matcher.matches();
    }
}
