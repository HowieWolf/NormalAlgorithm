package sort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 归并排序
 * 非递归实现
 */
public class MergeSortNoRecursive {
    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        for (int gap = 2; gap < data.length; gap *= 2) {
            sortInner(data, gap);
        }
    }

    private void sortInner(int[] data, int gap) {
        // 将整体分为多个长度为 gap 的小组，进行排序
        for (int i = 0; i < data.length; i += gap) {
            int end = i + gap >= data.length ? data.length - 1 : i + gap;
            merge(data, i, (i + end) >> 1, end);
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
        int[] array = ArrayUtils.newIntArray(7, 20);
        System.out.println(Arrays.toString(array));
        MergeSortNoRecursive sort = new MergeSortNoRecursive();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
