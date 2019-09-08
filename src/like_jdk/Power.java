package like_jdk;

/**
 * 剑指 16
 * 实现库函数 double power(double a, int b)
 * <p>
 * 注意：
 * 1）边界条件，a =0
 * 2）b 为负数
 */
public class Power {

    /**
     * 常规思路
     */
    public double power1(double a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        int e = Math.abs(b);
        int index = 0;
        double result = 1;
        while (index < e) {
            result *= a;
            index++;
        }
        if (b < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 2的8次幂，可以是2的4次幂乘2的4次幂
     */
    public double power2(double a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        int e = Math.abs(b);
        double result = a;
        int index = 1;
        while (index < e) {
            result *= result;
            index = index << 1;
        }
        // 如果是奇数次幂，就会多算了一次，所以
        if (index > e) {
            result /= a;
        }
        if (b < 0) {
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        Power test = new Power();
        double result = test.power2(2.0, 3);
        System.out.println(result);
    }
}
