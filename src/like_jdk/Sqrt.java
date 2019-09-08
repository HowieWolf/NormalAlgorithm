package like_jdk;

/**
 * leetcode 69
 * 实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 思路：
 * 一：使用二分法，但需要注意，求平方可能会溢出
 * 二：牛顿迭代
 */
public class Sqrt {

    /**
     * 二分法
     */
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long left = 2;
        long right = x >> 1;
        // 相邻的两个数求均值，下面会陷入死循环，所以加入 right-left > 1 的条件
        while (left < right && (right - left) > 1) {
            long middle = (left + right) >> 1;
            long s = middle * middle;
            if (s > x) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        Sqrt test = new Sqrt();
        int i = test.mySqrt(8);
        System.out.println(i);
    }
}
