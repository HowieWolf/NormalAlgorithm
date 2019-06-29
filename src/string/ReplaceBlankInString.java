package string;

/**
 * 将字符串中的空格替换成指定串
 *
 * 思路：正向计数，反向替换
 */
public class ReplaceBlankInString {

    private static final char BLACK = ' ';
    private static final String TARGET = "%20";

    public String replace(String origin) {
        int blackCount = 0;
        if (origin == null || origin.length() == 0 || (blackCount = countBlank(origin.toCharArray())) == 0) {
            return origin;
        }
        // 新长度是原长度 + 空格数*（替换长度-1）
        char[] target = new char[origin.length() + (TARGET.length() - 1) * blackCount];

        int indexOrigin = origin.length() - 1;
        int indexTarget = target.length - 1;
        while (indexOrigin >= 0 || indexTarget >= 0) {
            if (origin.charAt(indexOrigin) == BLACK) {
                replaceInner(target, indexTarget);
                // 原索引减一
                // 目标索引减替换长度
                indexTarget -= TARGET.length();
                indexOrigin--;
            } else {
                target[indexTarget--] = origin.charAt(indexOrigin--);
            }
        }
        return new String(target);
    }

    private void replaceInner(char[] target, int index) {
        for (int i = TARGET.length() - 1; i >= 0; i--) {
            target[index--] = TARGET.charAt(i);
        }
    }

    private int countBlank(char[] origin) {
        int count = 0;
        for (char c : origin) {
            if (c == BLACK) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReplaceBlankInString test = new ReplaceBlankInString();
        String origin = "we are fam ily ";
        String result = test.replace(origin);
        System.out.println(result);
    }
}
