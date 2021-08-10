/**
 * No.41 缺失的第一个正数
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/10 15:49
 */
public class L0041FirstMissingPositive {
    public static void main(String[] args) {

    }

    /**
     * 缺失的第一个正数 标记
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 整数数组
     * @return 最小正整数
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * 缺失的第一个正数 交换
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 整数数组
     * @return 最小正整数
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
