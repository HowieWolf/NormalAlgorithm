package fib;

/**
 * leetcode 53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 思路：
 * 典型的最优解问题，可以使用动态规划，间接变成斐波那契数列问题
 * 定义 f(n) 表示以 index 为 n 那个数结尾的子数组，和最大
 * <p>
 * 那么 f(n) = max{ f(n-1)+nums(n), nums(n) }
 */
public class MaxSumInSubarray {
    public int maxSubArray(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int t0 = nums[0];
        int result = t0;
        int index = 1;
        while (index < len) {
            int t = Math.max(nums[index], t0 + nums[index]);
            t0 = t;
            index++;
            if (t > result) {
                result = t;
            }
            System.out.println(t);
        }
        return result;
    }

    public static void main(String[] args){
        MaxSumInSubarray test = new MaxSumInSubarray();
        int result = test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(result);
    }
}
