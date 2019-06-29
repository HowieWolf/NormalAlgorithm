package array;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 在长度为 n+1 的数组中，只存在 1 到 n 的数字，一定存在重复的数字
 * 在不修改原数组的基础上，请给出任意一个重复的数字
 *
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumNotModifyInArray {

    public static final int FLAG_NOT_FOUND = -1;

    public int findRepeat(int[] nums) {
        if (ArrayUtils.isNullOrEmpty(nums)) {
            return FLAG_NOT_FOUND;
        }
        int start = 1;
        int end = nums.length - 1;
        int middle = (start + end) / 2;

        while (start != middle) {
            int count = count(nums, start, middle);
            int countOrigin = middle - start + 1;
            if (count > countOrigin) {
                end = middle;
                middle = (start + end) / 2;
            } else {
                start = middle + 1;
                middle = (start + end) / 2;
            }
        }
        return result(nums, start, middle);
    }

    private int result(int[] nums, int start, int middle) {
        // 处理结果
        int count = count(nums, start, middle);
        if (count > 1) {
            return start;
        } else {
            return start + 1;
        }
    }

    private int count(int[] data, int min, int max) {
        int count = 0;
        for (int d : data) {
            if (d >= min && d <= max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindRepeatNumNotModifyInArray test = new FindRepeatNumNotModifyInArray();
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(test.findRepeat(nums));
    }
}
