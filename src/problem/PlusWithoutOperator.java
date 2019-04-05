package problem;

/**
 * 不使用加减乘除运算符计算加法
 *
 * 思想：主要解决进位问题，将数字转换 3+7 = 4+6 = 2+8
 * 2 +8 就不需要进位，所以可以直接或运算或异或运算
 * 按位与，能够检查出哪些需要进位
 */
public class PlusWithoutOperator {

    public int plus(int a, int b) {
        int i;
        while ((i = a & b) != 0) {
            b = a ^ b;
            a = i << 1;
        }
        // 也可以 a | b
        return a ^ b;
    }

    public static void main(String[] args) {
        PlusWithoutOperator test = new PlusWithoutOperator();
        int result = test.plus(3, 7);
        System.out.println(result);
    }
}
