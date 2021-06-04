package array;

import java.util.Arrays;

/**
 * No.59 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/4 22:24
 */
public class L0059SpiralMatrixII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix2(1)));
        System.out.println(Arrays.deepToString(generateMatrix2(3)));
    }

    /**
     * 螺旋矩阵 II 模拟
     * 时间复杂度 O(N^2)
     * 空降复杂度 O(1)
     *
     * @param n 正整数
     * @return 矩阵
     */
    public static int[][] generateMatrix(int n) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];
        int[][] matrix = new int[n][n];
        int row = 0, col = 0;
        int directionIndex = 0;

        for (int i = 1; i <= Math.pow(n, 2); i++) {
            matrix[row][col] = i;
            visited[row][col] = true;

            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return matrix;
    }

    /**
     * 螺旋矩阵 II 按层模拟
     * 时间复杂度 O(N^2)
     * 空降复杂度 O(1)
     *
     * @param n 正整数
     * @return 矩阵
     */
    public static int[][] generateMatrix2(int n) {
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1;

        while (left <= right && top <= bottom && num <= Math.pow(n, 2)) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom ; row++) {
                matrix[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left ; col--) {
                    matrix[bottom][col] = num;
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
