package problem;

/**
 * 36 进制字符串加法
 * 不能使用直接转成 10 进制的方式
 */
public class Plus36RadisInString {

    private String p1;
    private String p2;

    final int RADIS = 36;

    public String plus() {
        int range = Math.max(p1.length(), p2.length());
        char plus = '0';
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < range; i++) {
            char[] result = plusOne(getNum(p1, i), getNum(p2, i), plus == '1');
            plus = result[0];
            builder.append(result[1]);
        }
        return builder.reverse().toString();
    }

    /**
     * plus 是否有进位
     * 返回相加结果
     */
    private char[] plusOne(char a, char b, boolean plus) {
        int result = parseInt(a) + parseInt(b);
        if (plus) {
            result++;
        }
        return new char[]{
                parseChar(result / RADIS),
                parseChar(result % RADIS)
        };
    }

    private char getNum(String num, int index) {
        if (num == null || num.isEmpty() || num.length() <= index) {
            return '0';
        }
        return num.charAt(num.length() - index - 1);
    }

    private int parseInt(char c) {
        c = Character.toLowerCase(c);
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return 0;
    }

    private char parseChar(int i) {
        i %= RADIS;
        if (i < 10) {
            return (char) ('0' + i);
        }
        return (char) ('A' + i - 10);
    }

    public static void main(String[] args) {
        Plus36RadisInString test = new Plus36RadisInString();
        test.p1 = "4ldqpds";
        test.p2 = "4ldqpds";
        System.out.println(test.plus());
    }
}
