package array;

import java.util.Arrays;

/**
 * No.209 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/1 16:12
 */
public class L0209MinimumSizeSubarraySum {
    public static void main(String[] args) {

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
    public int minSubArrayLen(int target, int[] nums) {
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

    /**
     * 长度最小的子数组 前缀和 + 二分查找
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param target 目标整数
     * @param nums 数组
     * @return 连续子数组最小长度
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            //  sums[bound] - sums[i - 1] >= target
            int boundTarget = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, boundTarget);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
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
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
