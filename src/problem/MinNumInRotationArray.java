package problem;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思想：有序查找要用二分降低时间复杂度
 */
public class MinNumInRotationArray {

    private int[] data;

    public int find() {
        if (data == null || data.length == 0) {
            return 0;
        }
        int left = 0;
        int right = data.length - 1;
        while (right - left > 1) {
            int middle = (left + right) / 2;
            if (data[left] > data[middle]) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return data[right];
    }

    public static void main(String[] args) {
        MinNumInRotationArray test = new MinNumInRotationArray();
        test.data = new int[]{3, 4, 5, 1, 2};
        System.out.println(test.find());
    }
}
