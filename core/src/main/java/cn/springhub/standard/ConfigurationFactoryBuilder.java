package cn.springhub.standard;

import java.io.InputStream;
import java.io.Reader;

/**
 *  builder的标准
 * @author A.I.
 * @createAt 2019/11/29 22:22
**/
public interface ConfigurationFactoryBuilder<T extends ConfigurationFactory<S>, S extends Configuration> {

    /**
     *  解析inputStream成配置
     * @param inputStream
     * @return
     */
    T build(InputStream inputStream);

    /**
     *  解析reader成配置
     * @param reader
     * @return
     */
    T build(Reader reader);

    /**
     *  构建连接工厂
     * @param configuration
     * @return
     */
    T build(S configuration);
}
