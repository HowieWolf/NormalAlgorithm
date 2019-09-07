package sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int lastIndex = data.length - 1;
        int flag = sortInner(data, 0, lastIndex);
        if (flag > 1) {
            sortInner(data, 0, flag - 1);
        }
        if (flag < lastIndex - 1) {
            sortInner(data, flag + 1, lastIndex);
        }
    }

    private int sortInner(int[] data, int left, int right) {
        int middle = (left + right) >> 1;
        while (left < right) {
            while (left < middle && data[left] <= data[middle]) {
                left++;
            }
            if (left < middle) {
                swap(data, left, middle);
                middle = left;
            }
            while (middle < right && data[middle] <= data[right]) {
                right--;
            }
            if (middle < right) {
                swap(data, right, middle);
                middle = right;
            }
        }
        return middle;
    }

    private void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.newIntArray(20, 50);
        System.out.println(Arrays.toString(array));
        QuickSort sort = new QuickSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
