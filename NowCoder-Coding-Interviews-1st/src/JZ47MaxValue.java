/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/2 16:02
 */
public class JZ47MaxValue {
    public static void main(String[] args) {

    }

    /**
     * 礼物的最大价值
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param grid 棋盘
     * @return 最大价值
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
