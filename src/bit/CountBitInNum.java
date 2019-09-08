package bit;

/**
 * leetcode 191
 * 计算一个数字中，二进制位中 1 的个数
 * 负数使用补码表示
 */
public class CountBitInNum {

    /**
     * 常规思路
     * 使用只有一位 1 的数字进行按位与，等于0表明当前位不是1，否则当前位是1
     * 例如，设标志是1，然后依次左移，直到标志为0
     */
    public int countBit1(int origin) {
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

    /**
     * 惊喜思路
     * 一个数，减去一，两个二进制比较的差别是原数最右边第一个1变0，后面的0全变1
     * 两数做与运算，保留了最右边第一个1左边的原数，而最右边第一个1变0
     * 依次重复，直到数字变0，重复多少次就有多少0
     */
    public int countBit2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
