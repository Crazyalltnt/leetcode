package dp;

/**
 * No.70 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/14 11:27
 */
public class L0070ClimbStairs {
    public static void main(String[] args) {
        int n = 2;
        // int n = 3;
        System.out.println(climbStairs(n));
    }

    /**
     * 爬楼梯 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param n 台阶数
     * @return 方案数
     */
    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }

    /**
     * 爬楼梯 动态规划 空间优化 滚动数组
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n 台阶数
     * @return 方案数
     */
    public static int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        }

        int p;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
