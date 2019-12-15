package cn.springhub.redis.commands;

import cn.springhub.redis.Configuration;
import cn.springhub.redis.RedisCommand;
import cn.springhub.redis.constant.RedisConstant;
import cn.springhub.utils.AssertUtils;
import cn.springhub.utils.Locale;
import cn.springhub.utils.SerializerUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 *  单机redis指令操作操作
 * @author A.I.
 * @createAt 2019/11/30 15:42
**/
public class RedisStandaloneCommand implements RedisCommand<Jedis> {

    protected final JedisPool jedisPool;

    protected Jedis jedis;

    protected boolean allowedNullValue = false;

    public RedisStandaloneCommand(JedisPoolConfig jedisPoolConfig, Configuration configuration) {
        this.jedisPool = new JedisPool(jedisPoolConfig, configuration.getHost(), configuration.getPort(), configuration.getConnectionTimeout(), configuration.getPassword());
        this.allowedNullValue = configuration.isAllowedNullValue();
    }

    /**
     *  获取连接
     * @return
     */
    @Override
    public Jedis getJedis() {
        if(jedis == null && (jedis = (Jedis) Locale.get(RedisConstant.REDIS_INSTANCE)) == null) {
            jedis = jedisPool.getResource();
            Locale.set(RedisConstant.REDIS_INSTANCE, jedis);
        }

        return jedis;
    }

    /**
     *  释放资源
     */
    @Override
    public void close() {
        if(jedis != null) {
            jedis.close();
            Locale.remove(RedisConstant.REDIS_INSTANCE);
            jedis = null;
        }
    }

    @Override
    public void set(Object key, Object value) {
        set(key, value, Duration.ZERO);
    }

    @Override
    public void set(Object key, Object value, Duration expire) {
        AssertUtils.isNotEmpty(key, RedisConstant.REDIS_KEY_NOT_BE_NULL.getValue());
        if(value == null && !allowedNullValue) {
            // 不运行null值
            return;
        }

        if(expire == null || expire.getSeconds() <= 0) {
            // 无过期时间
            getJedis().set(SerializerUtils.serialize(key), SerializerUtils.serialize(value));
        } else {
            // 有过期时间
            getJedis().setex(SerializerUtils.serialize(key), Long.valueOf(expire.getSeconds()).intValue(), SerializerUtils.serialize(value));
        }

        close();
    }

    @Override
    public Object get(Object key) {
        AssertUtils.isNotEmpty(key, RedisConstant.REDIS_KEY_NOT_BE_NULL.getValue());

        Object obj = SerializerUtils.deSerialize(getJedis().get(SerializerUtils.serialize(key)));
        close();

        return obj;
    }

    @Override
    public void del(Object key) {

    }

    @Override
    public boolean exist(Object key) {
        return false;
    }

    @Override
    public long incr(Object key) {
        AssertUtils.isNotEmpty(key, RedisConstant.REDIS_KEY_NOT_BE_NULL.getValue());

        long val = getJedis().incr(SerializerUtils.serialize(key));
        close();

        return val;
    }

    @Override
    public long decr(Object key) {
        AssertUtils.isNotEmpty(key, RedisConstant.REDIS_KEY_NOT_BE_NULL.getValue());

        long val = getJedis().decr(SerializerUtils.serialize(key));
        close();

        return val;
    }
}
