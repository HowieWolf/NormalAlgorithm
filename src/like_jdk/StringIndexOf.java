package like_jdk;

/**
 * leetcode 28 实现 {@link String#indexOf(String)}
 * 说明: 当 needle 是空字符串时，返回 0 。
 */
public class StringIndexOf {
    public int strStr(String haystack, String needle) {
        int hLen = 0;
        int nLen = 0;
        if (needle == null || (nLen = needle.length()) == 0) {
            return 0;
        }
        if (haystack == null || (hLen = haystack.length()) == 0
                || hLen < nLen) {
            return -1;
        }
        char first = needle.charAt(0);
        for (int i = 0; i <= hLen - nLen; ) {
            // 第一个字符不相同，直接下一个
            if (haystack.charAt(i) != first) {
                i++;
                continue;
            }
            // 开始比较字符串
            // 在遍历过程中，如果发现与第一个字符相同的 index，记录下来，下次直接从那里开始
            int next = 0;
            // 从第二个字符开始比较
            int j = 1;
            for (; j < nLen; j++) {
                char c = haystack.charAt(i + j);
                if (next == 0 && c == first) {
                    next = j;
                }
                if (c != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return i;
            }
            i += next == 0 ? j : next;
        }
        return -1;
    }

    public static void main(String[] args) {
        StringIndexOf test = new StringIndexOf();
        int i = test.strStr("hello", "ll");
        System.out.println(i);
    }
}
