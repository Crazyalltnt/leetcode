import java.util.logging.Level;

/**
 * No.198 打家劫舍
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/10 10:21
 */
public class L0198HouseRobber {
    public static void main(String[] args) {

    }

    /**
     * 打家劫舍 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最高金额
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1]  = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    /**
     * 打家劫舍 动态规划 滚动数组
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 最高金额
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int p = nums[0];
        int q = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = q;
            q = Math.max(p + nums[i], q);
            p = temp;
        }
        return q;
    }
}
