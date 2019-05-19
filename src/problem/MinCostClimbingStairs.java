package problem;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 思想：斐波那契数列
 * 如果要到达 n 层最小，则取决于到达 n-1 和 n-2 谁小
 * 递推式  f(n) = min( f(n-1), f(n-2) ) + c(n)
 * 其中 c(n) 函数表示第 n 层的花费
 * 转成非递归
 *
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int i0 = cost[0];
        int i1 = cost[1];
        int index = 2;
        while (index < cost.length) {
            int t = Math.min(i0, i1) + cost[index++];
            i0 = i1;
            i1 = t;
        }
        return Math.min(i0, i1);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs test = new MinCostClimbingStairs();
        int result = test.minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(result);
    }
}
