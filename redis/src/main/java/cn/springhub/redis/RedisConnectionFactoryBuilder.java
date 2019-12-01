package cn.springhub.redis;

import cn.springhub.redis.defaults.DefaultRedisConnectionFactory;
import cn.springhub.standard.ConfigurationFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;

/**
 *  创建redis连接工厂类
 * @author A.I.
 * @createAt 2019/11/29 22:20
**/
public class RedisConnectionFactoryBuilder implements ConfigurationFactoryBuilder<RedisConnectionFactory, Configuration> {

    @Override
    public RedisConnectionFactory build(InputStream inputStream) {
        return null;
    }

    @Override
    public RedisConnectionFactory build(Reader reader) {
        return null;
    }

    @Override
    public RedisConnectionFactory build(Configuration configuration) {
        return new DefaultRedisConnectionFactory(configuration);
    }
}
