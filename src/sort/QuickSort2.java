package sort;

import utils.ArrayUtils;

import java.util.Arrays;

public class QuickSort2 {

    public void sort(int[] num) {
        if (num == null || num.length < 2) {
            return;
        }
        sort(num, 0, num.length - 1);
    }

    private void sort(int[] num, int left, int right) {
        int flag = sortOnce(num, left, right);
        if (flag > left + 1) {
            sort(num, left, flag - 1);
        }
        if (flag < right - 1) {
            sort(num, flag + 1, right);
        }
    }

    private int sortOnce(int[] num, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int flag = (left + right) >> 1;
        while (left < right) {
            while (left < flag && num[left] <= num[flag]) {
                left++;
            }
            if (left < flag) {
                swap(num, left, flag);
                flag = left;
            }

            while (flag < right && num[flag] <= num[right]) {
                right--;
            }
            if (flag < right) {
                swap(num, flag, right);
                flag = right;
            }
        }
        return flag;
    }

    private void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.newIntArray(5, 50);
        System.out.println(Arrays.toString(array));
        new QuickSort2().sort(array);
        System.out.println(Arrays.toString(array));
    }

}
