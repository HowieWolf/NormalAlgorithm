package find;

/**
 * leetcode 33
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素，有可能不是旋转数组。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 思路：两次二分查找
 */
public class FindTargetInRotationArray {

    private static final int NOT_FOUNT = -1;

    public int search(int[] nums, int target) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return NOT_FOUNT;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : NOT_FOUNT;
        }
        int left = 0;
        int right = len - 1;
        if (nums[0] > nums[len - 1]) {
            int minIndex = findMinIndex(nums);
            if (target >= nums[0]) {
                right = minIndex - 1;
            } else {
                left = minIndex;
            }
        }
        return findTarget(nums, target, left, right);
    }

    private int findTarget(int[] nums, int target, int left, int right) {
        if (target < nums[left] || target > nums[right]) {
            return NOT_FOUNT;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            int tmp = nums[mid];
            if (tmp == target) {
                return mid;
            } else if (tmp > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return NOT_FOUNT;
    }

    /**
     * 返回最小数的 index
     *
     * @param data
     * @return
     */
    private int findMinIndex(int[] data) {
        int left = 0;
        int right = data.length - 1;
        while (right - left > 1) {
            int mid = (left + right) >> 1;
            if (data[left] > data[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
