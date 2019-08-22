package array;

import java.util.Arrays;

/**
 * leetcode 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * <p>
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * 思路：
 * 一遍快排
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) >> 1;
            while (left < right) {
                while (left < middle && isEven(nums[left])) {
                    left++;
                }
                if (left < middle) {
                    swap(nums, left, middle);
                    middle = left;
                }
                while (middle < right && !isEven(nums[right])) {
                    right--;
                }
                if (middle < right) {
                    swap(nums, middle, right);
                    middle = right;
                }
            }
        }
        return nums;
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }

    private void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    public static void main(String[] args) {
        SortArrayByParity test = new SortArrayByParity();
        int[] result = test.sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println(Arrays.toString(result));
    }
}
