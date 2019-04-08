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
        while (m >= 0 && n >= 0) {
            int current = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            nums1[index--] = current;
        }
        // 如果 nums2 中还有数据，n >=0，则需要复制到 nums1 中
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }

    /**
     * 思路：先插入，在合并
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i1 = 0;
        int i2 = 0;
        // 这里要使用原数组长度作为判断条件
        // 将 nums2 中部分数据插入到 nums1 中
        while (i2 < n && i1 < m) {
            int n1 = nums1[i1];
            int n2 = nums2[i2];
            if (n2 < n1) {
                moveRight(nums1, i1, m - 1);
                m++;
                nums1[i1] = n2;
                i2++;
            }
            i1++;
        }
        // 这里是将剩余的 nums2 中的数据合并到 nums1 中
        while (i2 < n && i1 < nums1.length) {
            nums1[i1++] = nums2[i2++];
        }
    }

    private void moveRight(int[] data, int start, int end) {
        while (end >= start) {
            data[end + 1] = data[end];
            end--;
        }
    }

    public static void main(String[] args) {
        MergeArray test = new MergeArray();
        int[] origin = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        test.merge(origin, 6, new int[]{1, 2, 2}, 3);
        System.out.println(Arrays.toString(origin));
    }
}
