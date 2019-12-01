package cn.springhub.redis;

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

    void set(String key, String value);




}
