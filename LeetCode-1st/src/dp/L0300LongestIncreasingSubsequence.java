package dp;

/**
 * No.300 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/14 20:34
 */
public class L0300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(nums));
    }

    /**
     * 最长递增子序列 动态规划
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子序列长度
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }


    /**
     * 最长递增子序列 贪心算法
     * 时间复杂度 O(N*logN)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子序列长度
     */
    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int length = 1;
        int[] d = new int[n + 1];
        d[length] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > d[length]) {
                d[++length] = nums[i];
            } else {
                int left = 1;
                int right = length;
                int pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return length;
    }
}
