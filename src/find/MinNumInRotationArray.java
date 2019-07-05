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
 */
public class MinNumInRotationArray {

    public int find(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        if (data.length == 1) {
            return data[0];
        }
        int start = 0;
        int end = data.length - 1;
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

    public static void main(String[] args) {
        MinNumInRotationArray test = new MinNumInRotationArray();
        int[] data = new int[]{3, 4, 5, 1, 2};
        System.out.println(test.find(data));
    }
}
