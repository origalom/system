package cn.springhub.redis.commands;

import cn.springhub.redis.Configuration;
import cn.springhub.redis.RedisCommand;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *  单机redis指令操作操作
 * @author A.I.
 * @createAt 2019/11/30 15:42
**/
public class RedisStandaloneCommand implements RedisCommand<Jedis> {

    protected final JedisPool jedisPool;

    protected Jedis jedis;

    public RedisStandaloneCommand(JedisPoolConfig jedisPoolConfig, Configuration configuration) {
        this.jedisPool = new JedisPool(jedisPoolConfig, configuration.getHost(), configuration.getPort(), configuration.getConnectionTimeout(), configuration.getPassword());
    }

    /**
     *  获取连接
     * @return
     */
    @Override
    public Jedis getJedis() {
        jedis = jedisPool.getResource();
        return jedis;
    }

    /**
     *  释放资源
     */
    @Override
    public void close() {
        if(jedis != null) {
            jedis.close();
        }
    }

    @Override
    public void set(String key, String value) {
        
    }
}
