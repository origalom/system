package cn.springhub.redis.defaults;

import cn.springhub.redis.Configuration;
import cn.springhub.redis.RedisCommand;
import cn.springhub.redis.RedisConnectionFactory;
import cn.springhub.redis.commands.RedisClusterCommand;
import cn.springhub.redis.commands.RedisStandaloneCommand;
import cn.springhub.utils.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *  默认redis连接工厂
 * @author A.I.
 * @createAt 2019/11/29 22:16
**/
public class DefaultRedisConnectionFactory implements RedisConnectionFactory {

    private final Configuration configuration;

    private final JedisPoolConfig jedisPoolConfig;

    private final RedisCommand redisCommand;

    public DefaultRedisConnectionFactory(Configuration configuration) {
        this.configuration = configuration == null ? new Configuration() : configuration;

        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(configuration.getMaxIdle());
        jedisPoolConfig.setMaxTotal(configuration.getMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(configuration.getMaxWaitMillis());
        jedisPoolConfig.setMinEvictableIdleTimeMillis(configuration.getMinEvictableIdleTimeMillis());
        jedisPoolConfig.setMinIdle(configuration.getMinIdle());
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(configuration.getSoftMinEvictableIdleTimeMillis());
        jedisPoolConfig.setNumTestsPerEvictionRun(configuration.getNumTestsPerEvictionRun());
        jedisPoolConfig.setTestOnBorrow(configuration.isTestOnBorrow());
        jedisPoolConfig.setTestWhileIdle(configuration.isTestWhileIdle());

        // 根据配置，进行选择是单机还是集群操作
        // 判断nodes是否存在
        if(StringUtils.isNotEmpty(configuration.getNodes())) {
            // 集群
//            redisCommand = new RedisClusterCommand(jedisPoolConfig, configuration);
            redisCommand = null;
        } else {
            // 单机
            redisCommand = new RedisStandaloneCommand(jedisPoolConfig, configuration);
        }
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }

    @Override
    public RedisCommand getRedisCommand() {
        return this.redisCommand;
    }
}
