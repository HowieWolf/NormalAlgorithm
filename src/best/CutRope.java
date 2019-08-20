package best;

import utils.ArrayUtils;

/**
 * 剑指 14
 * 一段长 n 米的绳子，剪成 m 段，m、n 都是整数，且大于 1，每段长度分别是 k1, k2 ... km，求 k1 * k2 * k3 ... km 的最大值；
 * <p>
 * 思考：
 * （1）贪心法
 * 通过数学证明 当 n>5, 3*(n-3)>2*(n-2)
 * 所以有如下贪心策略：
 * 1）不剪 1 米
 * 2）4 米时，剪成两个2 米
 * 3）5 米以上，均剪成 3 米
 * <p>
 * （2）动态规划
 * 设 f(n) 表示 n 米长的绳子剪成 m 段，乘积最大
 * 若第一刀 i 米，则 f(n) = i * f( n-i )
 * 所以，i 有很多种选择。
 * 如果穷举的话，会有很多重复计算的过程，所以可以将中间结果保存。
 * 或者可以从小往大算。
 *
 *
 * 注意：
 * 遇到 LeetCode 343
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
class CutRope {
    public static void main(String[] args) {
        CutRope test = new CutRope();
        int result = test.soluteBest(10);
        System.out.println(result);
    }

    public int soluteBest(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        // 加一是为了让 n = index
        int[] tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tmp[i] = soluteBestInner(i, tmp);
        }
        return tmp[n];
    }

    private int soluteBestInner(int n, int[] tmp) {
        int[] once = new int[n];
        once[0] = n;
        // 求解 f(n) = i * f( n-i )
        for (int i = 1; i < n; i++) {
            int t = n - i;
            once[i] = i * tmp[t];
        }
        tmp[n] = ArrayUtils.max(once);
        return tmp[n];
    }
}