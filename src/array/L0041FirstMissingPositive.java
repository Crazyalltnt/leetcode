package array;

/**
 * No.41 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 提示：
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/6 10:59
 */
public class L0041FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * 缺失的第一个正数 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 第一个正数
     */
    public static int firstMissingPositive(int[] nums) {
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
     * 缺失的第一个正数 置换
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 第一个正数
     */
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
