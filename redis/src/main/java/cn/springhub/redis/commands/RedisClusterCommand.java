package cn.springhub.redis.commands;

import cn.springhub.constant.SystemConstant;
import cn.springhub.redis.Configuration;
import cn.springhub.redis.RedisCommand;
import cn.springhub.utils.AssertUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *  集群cluster指令操作
 * @author A.I.
 * @createAt 2019/11/30 15:43
**/
public class RedisClusterCommand  {

    private final Set<HostAndPort> hostAndPorts;

    private final JedisPoolConfig jedisPoolConfig;

    private final Configuration configuration;

    public RedisClusterCommand(JedisPoolConfig jedisPoolConfig, Configuration configuration) {
        String[] hostAndPortStrArray = configuration.getNodes().split(SystemConstant.COMMA.getValue());

        hostAndPorts = new LinkedHashSet<>();
        for (String item : hostAndPortStrArray) {
            String[] hostAndPort = item.split(SystemConstant.COLON.getValue());

            AssertUtils.arrayLengthIsTrue(hostAndPort, 2, "集群端口配置有误，格式不对：" + item);
            AssertUtils.isNumber(hostAndPort[1], "集群端口号必须是整数：" + hostAndPort[1]);

            hostAndPorts.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
        }

        this.jedisPoolConfig = jedisPoolConfig;
        this.configuration = configuration;
    }

    public void getJedisCluster() {
        new JedisCluster(hostAndPorts, configuration.getConnectionTimeout(), jedisPoolConfig);
    }
}
