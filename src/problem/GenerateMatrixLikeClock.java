package problem;

public class GenerateMatrixLikeClock {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }
        int min = 0;
        int max = n;
        int[][] result = init(n);
        int start = 1;
        while (min < max) {
            start = generate(result, min++, --max, start);
        }
        return result;
    }

    private int generate(int[][] data, int min, int max, int start) {
        int i = 0;
        // 打印最上面一行
        for (i = min; i <= max; i++) {
            data[min][i] = start++;
        }
        // 打印最右边一列
        for (i = min + 1; i <= max; i++) {
            data[i][max] = start++;
        }
        if (min < max) {
            // 打印最下面一行（从右向左
            for (i = max - 1; i >= min; i--) {
                data[max][i] = start++;
            }
            // 打印最左面一列（从下向上
            for (i = max - 1; i > min; i--) {
                data[i][min] = start++;
            }
        }
        return start;
    }

    private int[][] init(int n) {
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = new int[n];
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateMatrixLikeClock test = new GenerateMatrixLikeClock();
        int[][] matrix = test.generateMatrix(3);
        PrintMatrixLikeClock check = new PrintMatrixLikeClock();
        for (Integer i : check.spiralOrder(matrix)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
