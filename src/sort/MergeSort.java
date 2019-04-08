package sort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        sortInner(data, 0, data.length - 1);
    }

    /**
     * [start,end] 闭区间
     */
    private void sortInner(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - start == 1) {
            if (data[end] < data[start]) {
                int t = data[end];
                data[end] = data[start];
                data[start] = t;
            }
        } else {
            int middle = (start + end) >> 1;
            sortInner(data, start, middle);
            sortInner(data, middle + 1, end);
            merge(data, start, middle, end);
        }
    }

    private void merge(int[] data, int start, int middle, int end) {
        int[] tmp = new int[end - start + 1];
        // 合并
        int i = start;
        int j = middle + 1;
        int index = 0;
        while (i <= middle || j <= end) {
            if (i > middle) {
                // j <= end
                tmp[index] = data[j++];
            } else if (j > end) {
                // i <= middle
                tmp[index] = data[i++];
            } else {
                tmp[index] = data[i] > data[j] ? data[j++] : data[i++];
            }
            index++;
        }
        // 复制回去
        for (i = 0; i < tmp.length; i++) {
            data[start + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.newIntArray(15, 20);
        System.out.println(Arrays.toString(array));
        MergeSort sort = new MergeSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
