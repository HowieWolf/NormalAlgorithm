package array;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 在长度为 n 的数组中，只存在 0 到 (n-1) 的数字，一定存在重复的数字
 * 请给出任意一个重复的数字
 */
public class FindRepeatNumInArray {

    public static final int FLAG_NOT_FOUND = -1;

    public int findRepeat(int[] nums) {
        if (ArrayUtils.isNullOrEmpty(nums)) {
            return FLAG_NOT_FOUND;
        }
        int length = nums.length;
        int index = 0;
        while (index < length) {
            int target = nums[index];
            if (index == target) {
                index++;
            } else if (target == nums[target]) {
                return target;
            } else {
                ArrayUtils.swap(nums, index, target);
            }
        }
        return FLAG_NOT_FOUND;
    }

    public static void main(String[] args) {
        FindRepeatNumInArray test = new FindRepeatNumInArray();
        int[] nums = ArrayUtils.newIntArray(10, 9);
        System.out.println(Arrays.toString(nums));
        System.out.println(test.findRepeat(nums));
    }
}
