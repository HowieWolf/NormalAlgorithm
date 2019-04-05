package problem;

/**
 * 计算一个数字中，二进制位中 1 的个数
 * 负数使用补码表示
 * <p>
 * 思想：使用只有一位 1 的数字进行按位与，等于0表明当前位不是1，否则当前位是1
 */
public class CountBitInNum {

    private int origin;

    private int count() {
        int t = 1;
        int count = 0;
        while (t != 0) {
            int result = origin & t;
            if (result != 0) {
                count++;
            }
            // 左移一位
            t <<= 1;
        }
        return count;
    }


}
