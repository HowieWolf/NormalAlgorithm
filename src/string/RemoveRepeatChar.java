package string;

import java.util.Arrays;

/**
 * 有序的字符数组去重
 * 返回去重后的数组长度
 */
public class RemoveRepeatChar {

    public int removeRepeatChar(int[] data) {
        int check = check(data);
        if (check >= 0) {
            return check;
        }
        return doRemove(data);
    }

    private int doRemove(int[] data) {
        int head = 0;
        int tail = 1;
        while (tail < data.length) {
            if (data[head] == data[tail]) {
                tail++;
            } else {
                data[++head] = data[tail++];
            }
        }
        return ++head;
    }

    private int check(int[] data) {
        if (data == null) {
            return 0;
        }
        int len = data.length;
        if (len < 2) {
            return len;
        }
        return -1;
    }

    public static void main(String[] args) {
        RemoveRepeatChar test = new RemoveRepeatChar();
        int[] data = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = test.removeRepeatChar(data);
        System.out.println(Arrays.toString(data));
        System.out.println(result);
    }
}
