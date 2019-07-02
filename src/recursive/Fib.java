package recursive;

/**
 * 斐波那契数列的非递归算法
 * 第一项 和 第二项 是 1
 * 后面每一项是前面两项之和
 */
public class Fib {

    public long fib(int n) {
        if (n < 3) {
            return 1;
        }
        int t1 = 1;
        int t2 = 1;
        int index = 3;
        while (index <= n) {
            int t = t1 + t2;
            t1 = t2;
            t2 = t;
            index++;
        }
        return t2;
    }
}
