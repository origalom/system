package cn.springhub.constant;

/**
 *  常量父类
 * @author  A.I.
 * @date   2019/11/25 11:19
 * @version   1.0
 **/
public interface Constant<T> {

    T getValue();

    String getDescription();
}
