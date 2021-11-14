/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/14 13:43
 */
public class JZ10NumWays {
    public static void main(String[] args) {

    }

    /**
     * 青蛙跳台阶问题 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param target 台阶数
     * @return 跳法数
     */
    public int jumpFloor(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[target];
    }

    /**
     * 青蛙跳台阶问题 动态规划 空间优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param target 台阶数
     * @return 跳法数
     */
    public int jumpFloor2(int target) {
        int p = 1, q = 1, r = 1;
        for (int i = 2; i <= target; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }
}
