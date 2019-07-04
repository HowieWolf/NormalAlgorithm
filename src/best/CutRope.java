package best;

/**
 * 剑指 14
 * 一段长 n 米的绳子，剪成 m 段，m、n 都是整数，每段长度分别是 k1, k2 ... km，求 k1 * k2 * k3 ... km 的最大值；
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
 * 这个题目稍微不同是至少剪两段，所以处理一下边界条件即可。
 */
class CutRope {
    public static void main(String[] args) {
        CutRope test = new CutRope();
        int result = test.soluteBest(10);
        System.out.println(result);
    }

    public int soluteBest(int n) {
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int[] tmp = new int[n + 1];
        return soluteBestInner(n, tmp);
    }

    private int soluteBestInner(int n, int[] tmp) {
        int result = tmp[n];
        // 已经计算过
        if (result != 0) {
            return result;
        }
        // 边界值
        if (n <5){
            tmp[n] = n;
            return n;
        }
        // 正常值
        int[] once = new int[n + 1];
        for (int i = 2; i < n; i++) {
            int t = n - i;
            tmp[t] = soluteBestInner(t, tmp);
            once[i] = i * tmp[t];
        }
        return max(once);
    }

    private int max(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public int soluteGreedy(int n) {
        if (n <= 4) {
            return n;
        }
        int result = 1;
        while (n >= 5) {
            result *= 3;
            n -= 3;
        }
        // 此时 n 只能是 4，3，2
        return result * n;
    }
}