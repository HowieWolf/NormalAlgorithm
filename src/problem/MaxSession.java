package problem;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.*;

/**
 * 题目描述
 * 每三个不同角色的人能够组成一个小组
 * 一个数组，数组长度表示角色个数，每个元素表示当前角色的人数
 * 输出当前状态能够组成多少个小组
 */
public class MaxSession {

    public int solute(int[] data) {
        if (data == null || data.length < 3) {
            return 0;
        }
        int len = data.length;
        int lastIndex = len - 1;
        int lastIndex2 = len - 2;
        int lastIndex3 = len - 3;
        int result = 0;
        while (true) {
            Arrays.sort(data);
            if (data[lastIndex3] <= 0) {
                break;
            }
            // 一定要一个一个的减
            data[lastIndex] -= 1;
            data[lastIndex2] -= 1;
            data[lastIndex3] -= 1;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSession test = new MaxSession();
        test.solute(new int[]{});
    }
}