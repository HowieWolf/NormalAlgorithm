package sort;

/**
 * 归并排序
 */
public class MergeSort {
    private int[] data;

    public void sort() {
        sortByDuration(data.length / 2);
    }

    private void sortByDuration(int duration) {
        if (duration == 1) {
            return;
        }
        sortByDuration(duration / 2);

    }
}
