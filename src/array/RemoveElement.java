package array;

/**
 * leetcode 27
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int newLen = nums.length;
        int i = 0;
        while (i < newLen) {
            if (nums[i] == val) {
                nums[i] = nums[--newLen];
            } else {
                i++;
            }
        }
        return newLen;
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] data = new int[]{0,1,2,2,3,0,4,2};
        int newLen = test.removeElement(data, 2);
        for (int i = 0; i < newLen; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
