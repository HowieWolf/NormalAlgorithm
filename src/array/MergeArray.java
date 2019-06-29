package array;

import java.util.Arrays;

/**
 * leetcode 88
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class MergeArray {

    /**
     * 思路：从后往前插入
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并后的遍历的 index，真实插入的 index
        int index = m + n - 1;
        // 取数的 index
        m--;
        n--;
        // 从后向前插入
        // 如果 num2 已经取完了，说明已经全部合并进入 num1，可以结束
        // 但这只能是没开辟新空间。如果是新开辟空间，将 num1 和 num2 合并，则不能这样
        while (n >= 0) {
            // 如果 num1 已经取完，则直接取 num2 的数
            if (m < 0 || nums2[n] > nums1[m]) {
                nums1[index--] = nums2[n--];
            } else {
                nums1[index--] = nums1[m--];
            }
        }
    }

    public static void main(String[] args) {
        MergeArray test = new MergeArray();
        int[] origin = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        test.merge(origin, 6, new int[]{1, 2, 2}, 3);
        System.out.println(Arrays.toString(origin));
    }
}
