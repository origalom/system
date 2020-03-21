package cn.springhub.algorithm;

import cn.springhub.algorithm.sort.Comparator;

/**
 *  排序类父类，统一定义排序输入方法
 * @author  A.I.
 * @date   2020/2/6 16:51
 * @version   1.0
 **/
public interface BaseSort {

    <T> T[] sort(T[] array, Comparator<T> comparator);
}
