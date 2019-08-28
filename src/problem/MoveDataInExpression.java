package problem;

/**
 * 问题描述
 * 输入一个只有 加减乘除 的表达式，交换数字的位置，使表达式的结果不变，且使数字是按照递增的顺序
 * 例如 3 + 2 + 1 + -4 * -5 + 1
 * 输出 1 + 2 + 3 + -5 * -4 + 1
 * 1 2 3 是能够交换位置的，虽然 -4 小于 1 但是不能交换
 *
 * 思路：
 * 冒泡排序，但是交换条件不再是简单的数值大小，还有其余的
 */
public class MoveDataInExpression {

    public void solute(int[] expression) {
        int[][] input = input(expression);
        int[] data = input[0];
        int[] op = input[1];
        if (op.length == 0) {
            print(data, op);
            return;
        }
        boolean hasSwap = false;
        for (int i = 0; i < op.length; i++) {
            hasSwap = false;
            for (int j = 0; j < op.length - i; j++) {
                if (canSwap(j, data, op)) {
                    int t = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = t;
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                break;
            }
        }
        print(data, op);
    }

    private boolean canSwap(int index, int[] data, int[] ops) {
        // 首先分析数值大小是否能换
        if (data[index] <= data[index + 1]) {
            return false;
        }
        // 然后分析操作符是否能换
        int op = ops[index];
        // 减和除都不能换
        if (op == '-' || op == '/') {
            return false;
        }
        // * 要看前面运算符
        if (op == '*') {
            return index == 0 || ops[index - 1] != '/';
        }
        // op == +
        // 前一个运算符没有，有就只能是 +
        // 后一个运算符没有，有就只能是 +-
        return (index == 0 || ops[index - 1] == '+')
                && (index == ops.length - 1 || ops[index + 1] == '+' || ops[index + 1] == '-');
    }

    private void print(int[] data, int[] op) {
        int i = 0;
        for (; i < op.length; i++) {
            System.out.print(data[i]);
            System.out.print(' ');
            System.out.print((char) op[i]);
            System.out.print(' ');
        }
        System.out.println(data[i]);
    }

    private int[][] input(int[] ex) {
        int[] op = new int[ex.length >> 1];
        int[] data = new int[op.length + 1];
        int i = 0;
        for (; i < op.length; i++) {
            data[i] = ex[i << 1];
            op[i] = ex[(i << 1) + 1];
        }
        data[i] = ex[i << 1];
        int[][] result = new int[2][];
        result[0] = data;
        result[1] = op;
        return result;
    }

    public static void main(String[] args) {
        MoveDataInExpression test = new MoveDataInExpression();
        test.solute(new int[]{3, '*', 2, '+', 1, '+', -4, '+', -5, '+', -11});
    }
}
