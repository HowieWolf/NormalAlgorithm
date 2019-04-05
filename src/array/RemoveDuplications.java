package array;

import java.util.Arrays;

/**
 * leetcode 80
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplications {

    private static final int MAX = 2;

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len <= MAX) {
            return len;
        }
        int current = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == current) {
                count++;
                continue;
            }
            if (count > MAX) {
                int removeCount = count - MAX;
                int to = i - removeCount;
                move(nums, to, i);
                len -= removeCount;
                i = to;
            }
            current = nums[i];
            count = 1;
        }
        if (count > MAX) {
            len -= (count - MAX);
        }
        return len;
    }

    /**
     * i 的位置是当前要填充的位置，i 之前的都是已经确定好
     * 由于有序，且要求最多有两个相同的。
     * 所以，你只要比 i-2 大，就可以留下。填充的位置就是 i
     * 如果小于等于 i-2，那就可能小于等于 i-1，所以不能要。
     */
    public int removeDeolicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < MAX || n > nums[i - MAX]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    private void move(int[] data, int to, int from) {
        if (data == null || to >= from || data.length <= from) {
            return;
        }
        while (from < data.length) {
            data[to++] = data[from++];
        }
    }

    public static void main(String[] args) {
        RemoveDuplications test = new RemoveDuplications();
        int[] data = {1, 1, 1, 1};
        int result = test.removeDuplicates(data);
        System.out.println(Arrays.toString(data));
        System.out.println(result);
    }
}
