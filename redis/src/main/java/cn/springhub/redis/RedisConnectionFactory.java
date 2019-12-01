package cn.springhub.redis;

import cn.springhub.standard.ConfigurationFactory;
import redis.clients.jedis.JedisPool;

/**
 *  redis连接工厂配置
 * @author A.I.
 * @createAt 2019/11/29 22:00
**/
public interface RedisConnectionFactory extends ConfigurationFactory<Configuration> {

    /**
     *  获取redis操作指令
     * @return
     */
    RedisCommand getRedisCommand();
}
