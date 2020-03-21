package cn.springhub.algorithm.sort;

/**
 *  排序的比较器，比较待排序的2个实例的大小
 * @author  A.I.
 * @date   2020/2/6 16:53
 * @version   1.0
 **/
@FunctionalInterface
public interface Comparator<T> {

    /**
     *  比较obj1和obj2，判断obj1是否大于obj2，
     *  由于相等时，无所谓谁大谁小，因此用boolean
      * @param obj1
     * @param obj2
     * @return
     */
    boolean compare(T obj1, T obj2);
}
