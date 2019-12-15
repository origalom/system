package cn.springhub.redis;

import lombok.Getter;
import lombok.Setter;

/**
 *  redis连接配置
 * @author A.I.
 * @createAt 2019/11/29 22:05
**/
@Getter
@Setter
public class Configuration implements cn.springhub.standard.Configuration {

    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 6379;
    public static final int DEFAULT_MAX_NUMBER = 8;
    public static final int DEFAULT_MIN_NUMBER = 0;
    public static final int DEFAULT_MAX_WAITMILLIS = -1;
    public static final long DEFAULT_MIN_EVICTABLE_IDLETIMEMILLIS = 180000L;
    public static final int DEFAULT_NUM_TESTS = 3;
    public static final boolean DEFAULT_CHECK = false;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 300;
    public static final int DEFAULT_MAX_ATTEMPS = 5;
    public static final int DEFAULT_SO_TIMEOUT = 60;

    /**
     *  主机名
     */
    private String host = DEFAULT_HOST;

    /**
     *  端口号
     */
    private int port = DEFAULT_PORT;

    /**
     *  连接nodes，配置了nodes表示是redis 集群
     */
    private String nodes;

    private int maxAttemps = DEFAULT_MAX_ATTEMPS;

    /**
     *  读取数据超时时间
     */
    private int soTimeout = DEFAULT_SO_TIMEOUT;

    /**
     *  密码
     */
    private String password;

    /**
     *  连接超时时间,单位秒
     */
    private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;

    /**
     *  最大空闲连接数
     */
    private int maxIdle = DEFAULT_MAX_NUMBER;

    /**
     *  最小空闲连接数
     */
    private int minIdle = DEFAULT_MIN_NUMBER;

    /**
     *  最大连接数
     */
    private int maxTotal = DEFAULT_MAX_NUMBER;

    /**
     *  获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
     */
    private int maxWaitMillis = DEFAULT_MAX_WAITMILLIS;

    /**
     *  逐出连接的最小空闲时间 默认600000毫秒(10分钟)
     */
    private long minEvictableIdleTimeMillis = DEFAULT_MIN_EVICTABLE_IDLETIMEMILLIS;

    /**
     *  每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
     */
    private int numTestsPerEvictionRun = DEFAULT_NUM_TESTS;

    /**
     *  对象空闲多久后逐出，当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
     */
    private long softMinEvictableIdleTimeMillis = DEFAULT_MIN_EVICTABLE_IDLETIMEMILLIS;

    /**
     *  在获取连接的时候检查有效性
     */
    private boolean testOnBorrow = DEFAULT_CHECK;

    /**
     *  在空闲时检查有效性, 默认false
     */
    private boolean testWhileIdle = DEFAULT_CHECK;

    /**
     *  允许null的值，空不算
     */
    private boolean allowedNullValue = DEFAULT_CHECK;
}
