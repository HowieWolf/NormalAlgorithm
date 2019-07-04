package best;

/**
 * leetcode 198
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 思路
 * 设 f(n) 表示n个房间，最大价值。n(i) 表示第 n 个房间的价值
 * 则 f(n) = max{ n(i)+f(n-2), n(i-1)+f(n-3) }
 * 既是动态规划，又是斐波那契数列
 */
public class Rob1 {

    public int rob(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int t0 = nums[0];
        if (len == 1) {
            return t0;
        }
        int t1 = max(t0, nums[1]);
        if (len == 2) {
            return t1;
        }
        int t2 = max(nums[2] + t0, t1);
        if (len == 3) {
            return t2;
        }
        int index = 3;
        while (index < len) {
            int h0 = nums[index] + t1;
            int h1 = nums[index - 1] + t0;
            t0 = t1;
            t1 = t2;
            t2 = max(h0, h1);
            index++;
        }
        return t2;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 7, 9, 3, 1};
        Rob1 test = new Rob1();
        int result = test.rob(data);
        System.out.println(result);
    }
}
