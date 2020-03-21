package cn.springhub.algorithm.sort;

import cn.springhub.algorithm.BaseSort;
import lombok.Data;

/**
 *  插入排序算法
 *      目标：对于少量元素的排序
 *      效率：设数组长度为n
 *          当n<=1时， 0次
 *          当n > 1时，最快 n -1次
 *                      最坏： n(n+1)/2 - 1
 * @author  A.I.
 * @date   2020/2/6 16:48
 * @version   1.0
 **/
@Data(staticConstructor = "of")
public class InsertionSort implements BaseSort {

    @Override
    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        if(array == null || array.length <= 1) {
            // 数组为空，或者只有1个元素，则无需进行判断，直接返回即可
            return array;
        }


        for (int i = 1; i < array.length; i++) {
            T key = array[i];

            int j = i - 1;
            // 数组是从头进行判断的，也就是说，当到达当前节点的时候，前面的数据肯定是按照顺序进行排序的，因此只需将当前的数据往前移动到适当位置即可
            // 利用数组前面的数据和当前数据进行比较
            // 如果前面的数据比当前数据大，则进行替换
            while (j >= 0 && comparator.compare(key, array[j])) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }

        return array;
    }
}
