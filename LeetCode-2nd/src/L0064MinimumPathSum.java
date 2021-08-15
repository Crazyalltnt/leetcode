/**
 * No.64 最小路径和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/15 9:45
 */
public class L0064MinimumPathSum {
    public static void main(String[] args) {

    }

    /**
     * 最小路径和
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param grid 网格
     * @return 最小路径总和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 最小路径和 空间优化
     * 时间复杂度 O(MN)
     * 空间复杂度 O(N)
     *
     * @param grid 网格
     * @return 最小路径总和
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
