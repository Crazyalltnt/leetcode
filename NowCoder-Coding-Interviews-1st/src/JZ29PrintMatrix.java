import java.util.ArrayList;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/26 17:06
 */
public class JZ29PrintMatrix {
    public static void main(String[] args) {

    }

    /**
     * 顺时针打印矩阵 按层模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param matrix 矩阵
     * @return 打印结果
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    res.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top ; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    /**
     * 顺时针打印矩阵 模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param matrix 矩阵
     * @return 打印结果
     */
    public ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1)% 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return res;

    }
}
