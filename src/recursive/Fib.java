package recursive;

/**
 * 斐波那契数列的非递归算法
 */
public class Fib {

    public long fib(int n) {
        if (n < 2) {
            return n;
        }
        long one = 0;
        long two = 1;
        long tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = one + two;
            one = two;
            two = tmp;
        }
        return tmp;
    }
}
