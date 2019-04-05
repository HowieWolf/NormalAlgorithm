package sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class QuickSort {

    private int[] data;

    public void sort() {
        sortInner(0, data.length - 1, 0);
    }

    private void sortInner(int start, int end, int flagIndex) {
        flagIndex = sortOnce(start, end, flagIndex);
        if (start < flagIndex) {
            sortInner(start, flagIndex - 1, start);
        }
        if (flagIndex < end) {
            sortInner(flagIndex + 1, end, end);
        }
    }

    private int sortOnce(int start, int end, int flagIndex) {
        while (start < end) {
            while (start < flagIndex && data[start] <= data[flagIndex]) {
                start++;
            }
            if (start < flagIndex) {
                swap(start, flagIndex);
                flagIndex = start;
            }
            while (flagIndex < end && data[flagIndex] <= data[end]) {
                end--;
            }
            if (flagIndex < end) {
                swap(flagIndex, end);
                flagIndex = end;
            }
        }
        return flagIndex;
    }

    private void swap(int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public QuickSort(int[] array) {
        this.data = array;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.newIntArray(20, 50);
        System.out.println(Arrays.toString(array));
        QuickSort sort = new QuickSort(array);
        sort.sort();
        System.out.println(Arrays.toString(sort.data));
    }
}
