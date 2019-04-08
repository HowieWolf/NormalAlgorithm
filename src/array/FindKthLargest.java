package array;

/**
 * leetcode 215
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return quickSort(nums, k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int start, int end) {
        int t = sortOnce(nums, start, end);
        // index ==0 ,表示 第1大
        if (t + 1 == k) {
            return nums[t];
        } else if (t + 1 > k) {
            return quickSort(nums, k, start, t - 1);
        } else {
            return quickSort(nums, k, t + 1, end);
        }
    }

    /**
     * 使用递增排序
     * 返回 index
     */
    private int sortOnce(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        // 选取中间作为 flag
        int flagIndex = (start + end) >> 1;
        while (start < end) {
            while (start < flagIndex && nums[start] >= nums[flagIndex]) {
                start++;
            }
            if (start < flagIndex) {
                swap(nums, start, flagIndex);
                flagIndex = start;
            }
            while (flagIndex < end && nums[end] <= nums[flagIndex]) {
                end--;
            }
            if (flagIndex < end) {
                swap(nums, flagIndex, end);
                flagIndex = end;
            }
        }
        return flagIndex;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
