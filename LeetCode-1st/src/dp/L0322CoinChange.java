package dp;

import java.util.Arrays;

/**
 * No.322 零钱兑换
 * https://leetcode-cn.com/problems/coin-change
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/21 22:14
 */
public class L0322CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        // int[] coins =  {2};
        // int amount = 3;
        System.out.println(coinChange(coins, amount));
    }

    static int res0 = Integer.MAX_VALUE;

    /**
     * 零钱兑换 暴力递归 超时
     *
     * @param coins  硬币种类
     * @param amount 总金额
     * @return 硬币最小数量
     */
    public static int coinChange0(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        findWay(coins, amount, 0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if (res0 == Integer.MAX_VALUE) {
            return -1;
        }
        return res0;
    }

    public static void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res0 = Math.min(res0, count);
        }

        for (int coin : coins) {
            findWay(coins, amount - coin, count + 1);
        }
    }

    /**
     * 兑换零钱 记忆化搜索
     * 时间复杂度 O(SN)
     * 空间复杂度 O(S)
     *
     * @param coins 硬币数组 n种面值
     * @param amount 金额 S
     * @return 硬币最小数量
     */
    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * 记忆化搜索 重载
     *
     * @param coins 硬币数组
     * @param rem 金额
     * @param count 记忆数组
     * @return 硬币最小数量
     */
    public static int coinChange(int[] coins, int rem, int[] count) {
        if (coins == null || coins.length == 0 || rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    /**
     * 零钱兑换 动态规划
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param coins 硬币数组
     * @param amount 金额
     * @return 硬币最小数量
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
