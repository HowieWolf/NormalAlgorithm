package find;

/**
 * 剑指 11
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：
 * 给出的所有元素都大于0，若数组大小为0，请返回0。
 * 假设数组中不存在重复的元素。
 * <p>
 * 思想：有序查找要用二分降低时间复杂度
 * 考虑边界情况：
 * 1 没有旋转，条件是最后一个值大于第一个值，则直接返回第一个
 * 2 旋转处正好是相等值，及第一个和最后一个相等
 */
public class MinNumInRotationArray {

    public int find(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int start = 0;
        int end = data.length - 1;
        // 没有旋转
        if (end == 0 || data[end] > data[start]) {
            return data[0];
        }

        // 旋转处是相等，调整开始和结束 index
        if (data[end] == data[start]) {
            end = adjustEnd(data);
            start = adjustStart(data);
        }

        while (end - start > 1) {
            int mid = (start + end) >> 1;
            if (data[start] > data[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return data[end];
    }

    /**
     * 调整的结果是指向相同值的后一个
     */
    private int adjustStart(int[] nums) {
        int start = 1;
        int maxIndex = nums.length-1;
        if (start < maxIndex && nums[start] == nums[start - 1]) {
            start++;
        }
        return start;
    }

    /**
     * 调整的结果是指向最后一个相同值
     */
    private int adjustEnd(int[] nums) {
        int end = nums.length - 1;
        if (end > 1 && nums[end] == nums[end - 1]) {
            end--;
        }
        return end;
    }

    public static void main(String[] args) {
        MinNumInRotationArray test = new MinNumInRotationArray();
        int[] data = new int[]{1,1,1};
        System.out.println(test.find(data));
    }
}
