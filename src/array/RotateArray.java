package array;

import java.util.Arrays;

/**
 * LeetCode 189
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }
        k %= len;
        if (k == 0) {
            return;
        }
        rotate(nums, 0, len - k - 1);
        rotate(nums, len - k, len - 1);
        rotate(nums, 0, len - 1);
    }

    private void rotate(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int a = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = a;
    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(data));
        test.rotate(data, 8);
        System.out.println(Arrays.toString(data));
    }
}
