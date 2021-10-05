import java.util.Arrays;

/**
 * No.209 长度最小的子数组
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/5 13:59
 */
public class L0209MinimumSizeSubarraySum {
    public static void main(String[] args) {

    }

    /**
     * 长度最小的子数组 前缀和 + 二分查找
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param target  目标值
     * @param nums 正整数数组
     * @return 长度
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= len; i++) {
            // prefixSum[bound] - prefixSum[i - 1] >= target
            int boundTarget = prefixSum[i - 1] + target;
            int bound = Arrays.binarySearch(prefixSum, boundTarget);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 长度最小的子数组 滑动窗口
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param target  目标值
     * @param nums 正整数数组
     * @return 长度
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int start = 0;
        int ans = Integer.MAX_VALUE;
        int sum  = 0;
        for (int end = 0; end < len; end++) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 长度最小的子数组 暴力
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param target 目标整数
     * @param nums 数组
     * @return 连续子数组最小长度
     */
    public int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
