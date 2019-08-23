package big_num;

/**
 * leetcode 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:你能不将整数转为字符串来解决这个问题吗？
 *
 * 思路：
 * 使用翻转数字的思路，翻转一半
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        // 整十整百一定不是
        if (x % 10 == 0){
            return false;
        }
        int half = 0;
        // 如果后一半大于了前一半，就直接结束，直接返回 false
        while (half < x) {
            int current = x % 10;
            x /= 10;
            // 这是判断奇数位的数字，将最后一位截去，再作比较
            if (x == half) {
                return true;
            }
            half = half * 10 + current;
            // 这是判断偶数位的数字
            if (half == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        boolean palindrome = test.isPalindrome(100);
        System.out.println(palindrome);
    }
}
