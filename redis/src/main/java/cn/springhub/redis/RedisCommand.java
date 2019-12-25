package cn.springhub.redis;

import java.time.Duration;

/**
 *  redis指令操作
 * @author A.I.
 * @createAt 2019/11/30 15:40
**/
public interface RedisCommand<T> {

    /**
     *  获取连接
     * @return
     */
    T getJedis();

    /**
     *  关闭连接，释放资源
     */
    void close();

    /**
     *  手动进行关闭连接，释放资源
     * @return
     */
    RedisCommand<T> closeAutoClose();

    /**
     * 设置指定key的值
     * @param key
     * @param value
     */
    void set(Object key, Object value);

    /**
     *  设置指定key的值和过期时间
     * @param key
     * @param value
     * @param expire    过期时间，为null或者<=0都不设置过期时间
     */
    void set(Object key, Object value, Duration expire);

    /**
     *  获取指定 key的值
     * @param key
     * @return
     */
    Object get(Object key);

    /**
     *  删除指定的key
     * @param key
     */
    void del(Object key);

    /**
     *  判断key是否存在
     * @param key
     * @return
     */
    boolean exist(Object key);

    /**
     *  将key中存储的数字值增1
     * @param key
     * @return
     */
    long incr(Object key);

    /**
     *  将key中存储的数字值减1
     * @param key
     * @return
     */
    long decr(Object key);
}
