import cn.springhub.algorithm.BaseSort;
import cn.springhub.algorithm.solution.FindMaximumSubarray;
import cn.springhub.algorithm.sort.InsertionSort;
import cn.springhub.algorithm.sort.MergeSort;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        double[] array = new double[]{112.0, 6.0, 5.0, 2.0, -31.0,0.0, 32.0};
//        InsertionSort.of().sort(array, (o1, o2)-> {
//            return o2 > o1;
//        });

//        BaseSort sort = MergeSort.of();
//        sort.sort(array, (o1, o2)-> {
//            return o1 < o2;
//        });

        System.out.println(FindMaximumSubarray.of().findMaximumSubarray(array));


//        for (Integer item : array) {
//            System.out.println(item);
//        }
    }
}
