package cn.springhub.utils;

import cn.springhub.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 *  线程局部变量
 * @author  A.I.
 * @date   2019/11/29 13:59
 * @version   1.0
 **/
public class Locale {
    private static final ThreadLocal<Map<Constant<String>, Object>> local = new ThreadLocal();

    /**
     *  向threadlocal中插入数据
     * @param key
     * @param obj
     */
    public static void set(Constant<String> key, Object obj) {
        Map<Constant<String>, Object> map = local.get();
        if(map == null) {
            map = new HashMap<>();
        }

        map.put(key, obj);
        local.set(map);
    }

    /**
     *  从threadlocal中取出数据
     * @param key
     */
    public static Object get(Constant<String> key) {
        Map<Constant<String>, Object> map = local.get();

        return map == null || map.isEmpty() ? null : map.get(key);
    }

    /**
     *  从本地种移除数据
     * @param key
     */
    public static void remove(Constant<String> key) {
        Map<Constant<String>, Object> map = local.get();
        if(map.containsKey(key)) {
            map.remove(key);
        }
    }
}
