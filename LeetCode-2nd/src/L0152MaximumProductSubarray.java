/**
 * No.152 乘积最大子数组
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/5 19:43
 */
public class L0152MaximumProductSubarray {
    public static void main(String[] args) {

    }

    /**
     * 乘积最大子数组 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 整数数组
     * @return 乘积最大子数组乘积
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }


        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int ans = dpMax[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            ans = Math.max(ans, dpMax[i]);
        }

        return ans;
    }

    /**
     * 乘积最大子数组 动态规划 空间优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 整数数组
     * @return 乘积最大子数组乘积
     */
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int dpMax = nums[0], dpMin = nums[0];
        int ans = dpMax;
        for (int i = 1; i < len; i++) {
            int tmpMax = dpMax;
            int tmpMin = dpMin;
            dpMax = Math.max(nums[i], Math.max(tmpMax * nums[i], tmpMin * nums[i]));
            dpMin = Math.min(nums[i], Math.min(tmpMax * nums[i], tmpMin * nums[i]));
            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}
