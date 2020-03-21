package cn.springhub.algorithm.solution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 *  查找数组A的一个最大子数组，即连续元素和最大的子数组
 *  只有当组数中包含负数时，最大子数组问题才有意义
 * @author  A.I.
 * @date   2020/2/10 11:20
 * @version   1.0
 **/
@Data(staticConstructor = "of")
public class FindMaximumSubarray {

    public MaximumSubarray findMaximumSubarray(double[] array) {
        return findMaximumSubarray(array, 0, array.length - 1);
    }

    private MaximumSubarray findMaximumSubarray(double[] array, int low, int high) {
        if(low == high) {
            return new MaximumSubarray(array, low, high, array[low]);
        } else {
            int mid = (low + high)/2;

            MaximumSubarray left = findMaximumSubarray(array, low, mid);
            MaximumSubarray right = findMaximumSubarray(array, mid + 1, high);
            MaximumSubarray cross = findMaxCrossingSubarray(array, low, mid, high);

            if(left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()) {
                return left;
            } else if(right.getSum() >= left.getSum() && right.getSum() >= cross.getSum()) {
                return right;
            } else {
                return cross;
            }

        }
    }

    /**
     *  设A的最大子数组开始下标为i, 结束下标为j，因此A[low...high]的最大子数组所处位置只有3种情况：
     *      1、完全位于A[low...mid]中，low <= i <= j <= mid
     *      2、完全位于A[mid+1...high]中，mid < i <= j <=high
     *      3、跨越了mid中心点，low <= i <= mid < j <= high
     * @param array 数组
     * @param low   数组开始位置
     * @param mid    数组中间位置
     * @param high 数组结束位置
     */
    private MaximumSubarray findMaxCrossingSubarray(double[] array, int low, int mid, int high) {
        // 最大子数组开始下标
        int maxLeft = mid, maxRight = mid;

        Double leftSum = null, rightSum = null;  // 最大子数组和的值
        double sum = 0;

        // 求解左侧做大值
        for(int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if(leftSum == null || sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        // 求解右侧最大值
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + array[j];
            if(rightSum == null || sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        return new MaximumSubarray(array, maxLeft, maxRight, (leftSum == null ? 0 : leftSum) + (rightSum == null ? 0 : rightSum));
    }

    @Getter
    @AllArgsConstructor
    @ToString
    class MaximumSubarray {
        double[] array;
        int start = 0;
        int end = 0;
        double sum;
    }
}
