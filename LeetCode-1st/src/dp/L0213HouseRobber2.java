package dp;

import java.util.Arrays;

/**
 * No.213 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/19 21:02
 */
public class L0213HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        // int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    /**
     * 环形打家劫舍 动态规划
     *
     * @param nums 数组
     * @return 最大金额
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robSub2(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            robSub2(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    /**
     * 单排打家劫舍 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最高金额
     */
    public static int robSub(int[] nums) {
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
     * 单排打家劫舍 动态规划 滚动数组
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 最高金额
     */
    public static int robSub2(int[] nums) {
        int p = 0;
        int q = 0;
        int r = 0;

        for (int num : nums) {
            r = Math.max(p + num, q);
            p = q;
            q = r;
        }

        return r;
    }
}
