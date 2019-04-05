package problem;

public class LeftRotateString {

    /**
     * 时间复杂度 O(n)，空间复杂度最坏 O(n)
     * 将要移动串复制出来，移位，然后放进去
     */
    public String leftRotate(String origin, int count) {
        if (origin == null || origin.length() == 0 || count == 0 || count == origin.length()) {
            return origin;
        }
        StringBuilder builder = new StringBuilder();
        int len = origin.length();
        while (builder.length() < len) {
            builder.append(origin.charAt(count % len));
            count++;
        }
        return builder.toString();
    }

    /**
     * 空间复杂度 O(1)
     * 思想 (XY)T = ( (Y)T (X)T )T
     */
    public char[] leftRotate(char[] origin, int count) {
        if (origin == null || origin.length == 0 || count == 0 || count == origin.length) {
            return origin;
        }
        reverse(origin, 0, origin.length);
        int index = origin.length - count;
        reverse(origin, 0, index);
        reverse(origin, index, origin.length);
        return origin;
    }

    /**
     * [start,end) 左闭右开
     */
    private void reverse(char[] origin, int start, int end) {
        while (start < end) {
            swap(origin, start++, --end);
        }
    }

    private void swap(char[] origin, int a, int b) {
        char t = origin[a];
        origin[a] = origin[b];
        origin[b] = t;
    }

    public static void main(String[] args) {
        LeftRotateString test = new LeftRotateString();
        String result = new String(test.leftRotate("HowieWang".toCharArray(), 5));
        System.out.println(result);
    }
}
