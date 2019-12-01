package cn.springhub.standard;

/**
 *  配置工厂
 * @author A.I.
 * @createAt 2019/11/29 22:24
**/
public interface ConfigurationFactory<T extends Configuration> {

    /**
     *  获取配置
     * @return
     */
    T getConfiguration();
}
