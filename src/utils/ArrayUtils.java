package utils;

public class ArrayUtils {

    public static int[] newIntArray(int length, int max) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * max);
        }
        return result;
    }

    public static boolean isNullOrEmpty(int[] data) {
        return data == null || data.length == 0;
    }

    public static void swap(int[] data, int index1, int index2) {
        int i = data[index1];
        data[index1] = data[index2];
        data[index2] = i;
    }
}
