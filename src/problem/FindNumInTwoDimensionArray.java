package problem;

import utils.ArrayUtils;

/**
 * 一个二维数组（每行的个数相同），从左向右递增，从上到下递增
 * 给定一个目标值，快速查找出是否存在
 */
public class FindNumInTwoDimensionArray {

    private static final int FLAG_ERROR = -1;
    private static final int FLAG_CORRECT = 0;
    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_UP = 2;

    public boolean find(int[][] data, int target) {
        if (data == null || data.length == 0 || ArrayUtils.isNullOrEmpty(data[0])) {
            return false;
        }
        int row = data.length - 1;
        int column = 0;
        while (true) {
            int direction = getDirection(data, row, column, target);
            switch (direction) {
                case FLAG_CORRECT:
                    return true;
                case FLAG_ERROR:
                    return false;
                case DIRECTION_RIGHT:
                    column++;
                    break;
                case DIRECTION_UP:
                    row++;
                    break;
            }
        }
    }

    private int getDirection(int[][] data, int row, int column, int target) {
        int maxRow = data.length;
        int maxColumn = data[0].length;
        if (row >= maxRow || column >= maxColumn) {
            return FLAG_ERROR;
        }

        int current = data[row][column];
        if (current == target) {
            return FLAG_CORRECT;
        }

        if (current > target) {
            return DIRECTION_UP;
        } else {
            return DIRECTION_RIGHT;
        }
    }

}
