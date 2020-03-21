package cn.springhub.algorithm.sort;

import cn.springhub.algorithm.BaseSort;
import lombok.Data;

/**
 *  归并排序算法
 * @author  A.I.
 * @date   2020/2/7 21:03
 * @version   1.0
 **/
@Data(staticConstructor = "of")
public class MergeSort implements BaseSort {

    @Override
    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        if(array == null || array.length <= 1) {
            return array;
        }

        merge(array, 0, array.length - 1, (o1, o2) -> {
            return comparator.compare((T) o1, (T) o2);
        });

        return array;
    }

    public <T> void merge(T[] array, int p, int r, Comparator comparator) {
        if(p < r) {
            int q = (p + r)/2;

            merge(array, p, q, comparator);
            merge(array, q + 1, r, comparator);
            merge(array, p, q, r, comparator);
        }
    }

    /**
     *  p <= q < r
     */
    public <T> void merge(T[] array, int p, int q, int r, Comparator comparator) {
        int n1 = q - p + 1, n2 = r - q, i = 0, j = 0;

        // 初始化2个子数组
        Object[] first = new Object[n1];
        Object[] second = new Object[n2];
        for(; i < n1; i++) {
            first[i] = array[p + i];
        }
        for (; j < n2; j++) {
            second[j] = array[q + j + 1];
        }

        // 比较重新排序数组
        i = 0; j = 0;
        for (int k = p; k <= r; k++) {
            // 如果某个数组已经到达最大值，则直接将另一个数组拼接到原数组后
            if( j < second.length && (i >= first.length || comparator.compare(second[j], first[i]))) {
                array[k] = (T) second[j];
                j ++;
            } else if(i < first.length) {
                array[k] = (T) first[i];
                i ++;
            } else {
                break;
            }
        }
    }
}
