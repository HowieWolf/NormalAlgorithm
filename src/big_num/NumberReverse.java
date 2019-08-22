package big_num;

/**
 * leetcode 7 整数翻转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class NumberReverse {
    public int reverse(int x) {
        int rec = 0;
        while (x != 0) {
            int current = x % 10;
            x = x / 10;
            if (isOverflow(rec, current)) {
                return 0;
            }
            rec = rec * 10 + current;
        }
        return rec;
    }

    private boolean isOverflow(int hight, int low) {
        int max = Integer.MAX_VALUE / 10;
        if (hight > max) {
            return true;
        }
        if (hight == max && low > Integer.MAX_VALUE % 10) {
            return true;
        }
        int min = Integer.MIN_VALUE / 10;
        if (hight < min) {
            return true;
        }
        if (hight == min && low < Integer.MIN_VALUE % 10) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int reverse = new NumberReverse().reverse(Integer.MIN_VALUE);
        System.out.println(reverse);
    }
}
