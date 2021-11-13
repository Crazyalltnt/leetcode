/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/13 20:01
 */
public class JZ42MaxSubArray {
    public static void main(String[] args) {

    }

    /**
     * 连续子数组的最大和 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param array 数组
     * @return 最大和
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = array[i] + Math.max(dp[i - 1], 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 连续子数组的最大和 动态规划 简化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @return 最大和
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int pre = 0, ans = array[0];
        for (int num : array) {
            pre = Math.max(pre, 0) + num;
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
