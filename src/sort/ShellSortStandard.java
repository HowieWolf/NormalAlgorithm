package sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class ShellSortStandard {
    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int duration = data.length / 2;
        while (duration > 0) {
            sortInner(data, duration);
            duration /= 2;
        }
    }

    private void sortInner(int[] data, int duration) {
        for (int i = 0; i < duration; i++) {
            standardInsertSort(data, duration, i);
        }
    }

    /**
     * 标准的直接插入排序
     */
    private void standardInsertSort(int[] data, int duration, int start) {
        for (int i = start + duration; i < data.length; i = i + duration) {
            // data[i] 是本次要插入的数值
            // 下面的循环是为这个数找合适的位置
            int currentData = data[i];
            int j = start;
            while (j < i) {
                if (!(currentData >= data[j])) break;
                j += duration;
            }
            // 将 j 到 i 之间的往后移
            for (int k = i; k > j; ) {
                int t = k - duration;
                data[k] = data[t];
                k = t;
            }
            // 然后将 i 填充到 j 处
            data[j] = currentData;
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.newIntArray(5, 20);
        System.out.println(Arrays.toString(array));
        ShellSortStandard test = new ShellSortStandard();
        test.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
