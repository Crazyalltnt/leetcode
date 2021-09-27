/**
 * No.59 螺旋矩阵 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/27 10:36
 */
public class L0059SpiralMatrixII {
    public static void main(String[] args) {

    }

    /**
     * 螺旋矩阵 II 模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param n 正整数
     * @return 矩阵
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0, col = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[row][col] = i;
            visited[row][col] = true;
            int newRow = row + direction[directionIndex][0];
            int newCol = col + direction[directionIndex][1];
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return ans;
    }

    /**
     * 螺旋矩阵 II 按层模拟
     * 时间复杂度 O(MN)
     * 空间复杂度 O(1)
     *
     * @param n 正整数
     * @return 矩阵
     */
    public int[][] generateMatrix2(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;

        while (left <= right && top <= bottom && num <= n * n) {
            for (int col = left; col <= right; col++) {
                ans[top][col] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                ans[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    ans[bottom][col] = num;
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    ans[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
