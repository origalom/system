package cn.springhub.redis.constant;

import cn.springhub.constant.Constant;

/**
 * redis常量
 * @author A.I.
 * @createAt 2019/12/14 16:44
**/
public enum RedisConstant implements Constant<String> {
    REDIS_INSTANCE("REDIS_INSTANT")

    , REDIS_KEY_NOT_BE_NULL("指定key的值不能为空")
    ;

    private String key;

    RedisConstant(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return this.key == null || this.key.length() == 0 ? this.name() : this.key;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
