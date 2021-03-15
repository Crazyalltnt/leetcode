package dp;

/**
 * No.198 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/15 11:41
 */
public class L0198HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob2(nums));
    }

    /**
     * 偷取的最高金额 动态规划
     *
     * @param nums 数组
     * @return 总金额
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }


    /**
     * 偷取的最高金额 动态规划 滚动数组
     *
     * @param nums 数组
     * @return 总金额
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int p = nums[0];
        int q = Math.max(nums[0], nums[1]);
        int r = q;

        for (int i = 2; i < n; i++) {
            r = Math.max(p + nums[i], q);
            p = q;
            q = r;
        }
        return r;
    }
}
