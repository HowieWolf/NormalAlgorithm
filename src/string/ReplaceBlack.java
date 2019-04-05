package string;

/**
 * 将字符串中的空格替换成指定串
 */
public class ReplaceBlack {
    private StringBuilder origin;

    final char source = ' ';
    final String target = "%20";

    public void replace() {
        int count = countBlack();
        int originalLen = origin.length();
        origin.setLength(originalLen + (target.length() - 1) * count);
        int indexA = originalLen - 1;
        int indexB = origin.length() - 1;
        while (indexA != indexB) {
            char c = origin.charAt(indexA--);
            if (c == source) {
                put(indexB);
                indexB -= target.length();
                continue;
            }
            origin.setCharAt(indexB--, c);
        }
    }

    private void put(int index) {
        int len = target.length();
        for (int i = 0; i < len; i++) {
            origin.setCharAt(index - len + i + 1, target.charAt(i));
        }
    }

    private int countBlack() {
        int count = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == source) {
                count++;
            }
        }
        return count;
    }
}
