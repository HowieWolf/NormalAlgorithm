package problem;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * */
public class PrintMatrixLikeClock {
    public List<Integer> spiralOrder(int[][] data) {
        if (data == null || data.length == 0 || data[0] == null || data[0].length == 0) {
            return new ArrayList<>();
        }
        int top = 0;
        int down = data.length;
        int left = 0;
        int right = data[0].length;
        List<Integer> result = new ArrayList<>();
        while (top < down && left < right) {
            printInner(data, top++, --down, left++, --right, result);
        }
        return result;
    }

    private void printInner(int[][] data, int top, int down, int left, int right, List<Integer> result) {
        int i = 0;
        // 打印最上面一行
        for (i = left; i <= right; i++) {
            result.add(data[top][i]);
        }
        // 打印最右边一列
        for (i = top + 1; i <= down; i++) {
            result.add(data[i][right]);
        }
        // 打印最下面一行（从右向左
        if (top < down) {
            for (i = right - 1; i >= left; i--) {
                result.add(data[down][i]);
            }
        }
        // 打印最左面一列（从下向上
        if (left < right) {
            for (i = down - 1; i > top; i--) {
                result.add(data[i][left]);
            }
        }
    }
}
