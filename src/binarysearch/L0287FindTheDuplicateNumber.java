package binarysearch;

/**
 * No.287 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数，找出这个重复的数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：nums = [1,1]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：nums = [1,1,2]
 * 输出：1
 * <p>
 * 提示：
 * 2 <= n <= 3 * 104
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * <p>
 * 进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以在不修改数组 nums 的情况下解决这个问题吗？
 * 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
 * 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/26 10:50
 */
public class L0287FindTheDuplicateNumber {
    public static void main(String[] args) {
        // int[] nums = {1, 3, 4, 2, 2};
        int[] nums = {3, 1, 3, 4, 2};

        System.out.println(findDuplicate(nums));
    }

    /**
     * 寻找重复数 二分查找
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 重复数值
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 寻找重复数 二进制
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 重复数值
     */
    public static int findDuplicate2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int bitMax = 31;
        while (((n - 1) >> bitMax) == 0) {
            bitMax--;
        }

        for (int bit = 0; bit < bitMax; bit++) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x++;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y++;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }

    /**
     * 寻找重复数 快慢指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 重复数值
     */
    public static int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
