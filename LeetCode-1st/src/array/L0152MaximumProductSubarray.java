package array;

/**
 * No.152 乘积最大子数组
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/1 22:18
 */
public class L0152MaximumProductSubarray {
    public static void main(String[] args) {

    }

    /**
     * 乘积最大子数组 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子数组乘积
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        System.arraycopy(nums, 0, dpMax, 0, n);
        System.arraycopy(nums, 0, dpMin, 0, n);
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
        }
        int ans = dpMax[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }

    /**
     * 乘积最大子数组 动态规划 空间优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 子数组乘积
     */
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int dpMax = nums[0], dpMin = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            int max = dpMax, min = dpMin;
            dpMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            dpMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            ans = Math.max(dpMax, ans);
        }
        return ans;
    }
}
