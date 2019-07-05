package bit;

/**
 * LeetCode 231
 * 判断一个数是否是 2 的幂
 * 方案一：判断每一位是否是 1，如果只有一个 1，则是，否则，不是
 * 方案二：n 和 n-1 进行按位与，得 0
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        int count = 0;
        // 符号位不算
        for (int i = 0; i < 31; i++) {
            if (isOneInBit(n, i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 在 index 的 bit 位上是1
     * index 从右开始数
     */
    private boolean isOneInBit(int n, int index) {
        return (n & (1 << index)) != 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo text = new IsPowerOfTwo();
        for (int i = 0; i < 100; i++) {
            boolean result = text.isPowerOfTwo(i);
            System.out.println(i + "--" + result);
        }
    }
}
