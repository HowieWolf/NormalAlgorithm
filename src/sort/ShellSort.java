package sort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 希尔排序
 * 思想：减小增量排序
 * 假设数组长度为 8，则第一次的增量为 4，整个数组会被分成四组，分别是[0,4],[1,5],[2,6],[3,7]，组内进行排序
 * 第二次增量是 2，整个数组被分为两组，分别是[0,2,4,6][1,3,5,7]，组内排序
 * 最后一次增量是1。
 * 在进行组内排序的时候，自由度就比较高了。可以一组一组的进行，也可以穿插着进行。下面的实现方式就是穿插进行的。
 */
public class ShellSort {

    public void sort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            sortInner(data, gap);
        }
    }

    private void sortInner(int[] data, int gap) {
        for (int i = gap; i < data.length; i++) {
            int j = i;
            while (j - gap >= 0 && data[j] < data[j - gap]) {
                swap(data, j, j - gap);
                j -= gap;
            }
        }
    }

    private void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.newIntArray(5, 20);
        System.out.println(Arrays.toString(array));
        ShellSort sort = new ShellSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
