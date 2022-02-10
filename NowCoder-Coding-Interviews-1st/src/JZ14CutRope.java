/**
 * 剑指 Offer 14- I. 剪绳子
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/9 20:27
 */
public class JZ14CutRope {
    public static void main(String[] args) {

    }

    /**
     * 剪绳子 数学
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param target 长度
     * @return 乘积
     */
    public int cutRope(int target) {
        if (target <= 3) {
            return target - 1;
        }
        int a = target / 3;
        int b = target % 3;
        if (b == 0) {
            return (int)Math.pow(3, a);
        } else if (b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        } else {
            return (int)Math.pow(3, a) * 2;
        }
    }

    /**
     * 剪绳子 动态规划
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param target 长度
     * @return 乘积
     */
    public int cutRope2(int target) {
        int[] dp = new int[target + 1];
        for (int i = 2; i <= target; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[target];
    }
}
