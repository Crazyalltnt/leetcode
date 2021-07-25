/**
 * No.70 爬楼梯
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/25 23:10
 */
public class L0070ClimbingStairs {
    public static void main(String[] args) {

    }

    /**
     * 爬楼梯 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param n 楼梯阶数
     * @return 方案数
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 爬楼梯 动态规划 滚动数组 空间优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n 楼梯阶数
     * @return 方案数
     */
    public int climbStairs2(int n) {
        int p, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 爬楼梯 斐波那契数列 通项公式 f(n+1)
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param n 楼梯阶数
     * @return 方案数
     */
    public int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fib / sqrt5);
    }
}
