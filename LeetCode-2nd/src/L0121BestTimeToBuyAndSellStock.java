/**
 * No.121 买卖股票的最佳时机
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/19 12:04
 */
public class L0121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 买卖股票的最佳时机 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    /**
     * 买卖股票的最佳时机 动态规划 空间优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][1] = Math.max(-prices[i], dp[(i - 1) % 2][1]);
        }
        return dp[(n - 1) % 2][0];
    }

    /**
     * 买卖股票的最佳时机 动态规划 空间优化plus
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        int p = 0, q = -prices[0];
        for (int i = 1; i < n; i++) {
            p = Math.max(p, q + prices[i]);
            q = Math.max(-prices[i], q);
        }
        return p;
    }

    /**
     * 买卖股票的最佳时机 一次遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param prices 价格
     * @return 最大利润
     */
    public static int maxProfit4(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
