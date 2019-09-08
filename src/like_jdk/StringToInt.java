package like_jdk;

/**
 * 将字符串转换为 int
 * 可能带正负号
 */
public class StringToInt {

    public int stringToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        // 处理正负号
        char c = str.charAt(i);
        if (c == '+' || c == '-') {
            // 需要从 index=1 开始计算
            i = 1;
            if (c == '-') {
                flag = -1;
            }
        }
        // 开始计算
        int result = 0;
        for (; i < str.length(); i++) {
            Integer num = getIntAt(str, i);
            if (num == null) {
                return 0;
            } else {
                result = multiplyAndPlus(result, num);
            }
        }
        return result * flag;
    }

    private Integer getIntAt(String s, int index) {
        char c = s.charAt(index);
        if (c < '0' || c > '9') {
            return null;
        }
        return c - '0';
    }

    private int multiplyAndPlus(int base, int add) {
        base *= 10;
        return base + add;
    }

    public static void main(String[] args) {
        StringToInt test = new StringToInt();
        int result = test.stringToInt("03r43222");
        System.out.println(result);
    }
}
