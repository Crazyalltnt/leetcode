/**
 * No.122 买卖股票的最佳时机 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/22 19:05
 */
public class L0122BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

    }

    /**
     * 买卖股票的最佳时机 II 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    /**
     * 买卖股票的最佳时机 II 动态规划 简化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        int[] dp = new int[2];
        int[] newDp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            newDp[0] = Math.max(dp[0], dp[1] + prices[i]);
            newDp[1] = Math.max(dp[0] - prices[i], dp[1]);
            dp[0] = newDp[0];
            dp[1] = newDp[1];
        }
        return dp[0];
    }

    /**
     * 买卖股票的最佳时机 II 贪心
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
