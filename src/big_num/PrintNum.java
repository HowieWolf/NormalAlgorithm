package big_num;

/**
 * 剑指 17
 * 输入一个 n，请输出 1 到 最大 n 位数
 * 例如，3，则输出 1到999
 * <p>
 * 由于 n 可能是个非常大的数，会超出表示范围，所以大数问题用字符串解决才是正确的。
 * 拓展思考：
 * 1）如果n位十进制数最大值，小于int 或 long 的最大值，可以考虑直接使用 int 或 long
 * 2）一个 char 可以表示 256，但现在只用了 10 个符号，有些浪费，可以让一个 char 表示两位数。
 */
public class PrintNum {

    public void print(int n) {
        if (n <= 0) {
            return;
        }
        char[] num = new char[n];
        recursive(num, 0);
    }

    private void recursive(char[] num, int index) {
        int maxIndex = num.length - 1;
        if (index > maxIndex) {
            return;
        }
        for (char c = '0'; c <= '9'; c++) {
            num[index] = c;
            if (index == maxIndex) {
                print(num);
            } else {
                recursive(num, index + 1);
            }
        }
    }

    private void print(char[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        boolean isStart = false;
        for (char c : num) {
            if (isStart) {
                builder.append(c);
            } else if (c != '0') {
                isStart = true;
                builder.append(c);
            }
        }
        if (builder.length() >6) {
            System.out.println(builder.toString());
        }
    }

    public static void main(String[] args) {
        PrintNum test = new PrintNum();
        test.print(7);
    }
}
