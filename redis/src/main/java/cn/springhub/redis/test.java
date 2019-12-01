package cn.springhub.redis;

public class test {

    public static void main(String[] args) {
        RedisConnectionFactory redisConnectionFactory = new RedisConnectionFactoryBuilder().build(new Configuration());

        redisConnectionFactory.getRedisCommand();
    }
}
