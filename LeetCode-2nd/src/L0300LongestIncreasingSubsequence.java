/**
 * No.300 最长递增子序列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/27 14:41
 */
public class L0300LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    /**
     * 最长递增子序列 动态规划
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最长递增子序列长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 最长递增子序列 贪心 + 二分查找
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最长递增子序列长度
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int len = 1;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len, pos = 0;
                while (left <= right) {
                    int mid =  (left + right) / 2;
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
        return len;
    }
}
