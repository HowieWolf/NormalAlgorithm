package utils;

public class ArrayUtils {

    public static int[] newIntArray(int length, int max) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * max);
        }
        return result;
    }
}
