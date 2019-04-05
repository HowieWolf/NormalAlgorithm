package array;

/**
 * 在长度为 n 的数组中，只存在 0 到 (n-1) 的数字，一定存在重复的数字
 * 请给出任意一个重复的数字
 */
public class FindRepeatNumInArray {

    private static final int NEXT_FLAG = -1;

    public int findRepeat(int[] data) {
        if (data == null) {
            return NEXT_FLAG;
        }
        for (int i = 0; i < data.length; i++) {
            int canNext = canNext(data, i);
            if (canNext != NEXT_FLAG) {
                return canNext;
            }
        }
        return NEXT_FLAG;
    }

    /**
     * 我们假设每个数在对应的 index 处
     * 如果当前 index == data[index] 则继续向后循环
     * 否则比较 data[index] data[data[index]]（因为 index 为 data[index] 应该在 data[index] 处
     * 如果相等，就找到了重复值，否则交换，继续比较
     */
    private int canNext(int[] data, int currentIndex) {
        while (true) {
            int currentData = data[currentIndex];
            if (currentIndex == currentData) {
                return NEXT_FLAG;
            }
            if (currentData == data[currentData]) {
                return currentData;
            }
            swap(data, currentIndex, currentData);
        }
    }

    private void swap(int[] data, int i1, int i2) {
        int t = data[i1];
        data[i1] = data[i2];
        data[i2] = t;
    }

    public static void main(String[] args) {
        FindRepeatNumInArray test = new FindRepeatNumInArray();
        test.findRepeat(null);
    }
}
