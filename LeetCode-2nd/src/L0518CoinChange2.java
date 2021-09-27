/**
 * No.518 零钱兑换 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/27 19:57
 */
public class L0518CoinChange2 {
    public static void main(String[] args) {

    }

    /**
     * 零钱兑换 II 动态规划
     * 时间复杂度 O(MN)
     * 空间复杂度 O(N)
     *
     * @param amount 总金额
     * @param coins 硬币数组
     * @return 组合数
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
