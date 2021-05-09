package bitmanipulation;

import java.util.*;

/**
 * No.268 丢失的数字
 * https://leetcode-cn.com/problems/missing-number
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 进阶：
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/9 20:08
 */
public class L268MissingNumber {
    public static void main(String[] args) {

    }

    /**
     * 丢失的数字 哈希表键值对
     * 时间复杂度 O(N)
     * 空间复杂度 O(n)
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>(n);
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= n; i++) {
            if (count.getOrDefault(i, 0) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 丢失的数字 哈希表键集合
     * 时间复杂度 O(N)
     * 空间复杂度 O(n)
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 丢失的数字 排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    public static int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0) {
            return 0;
        } else if (nums[n - 1] != n) {
            return n;
        }

        for (int i = 1; i < n; i++) {
            int ans = nums[i - 1] + 1;
            if (ans != nums[i]) {
                return ans;
            }
        }
        return -1;
    }

    /**
     * 丢失的数字 位运算
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    public static int missingNumber4(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }

    /**
     * 丢失的数字 数学
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    public static int missingNumber5(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int totalSum = nums.length * (1 + nums.length) / 2;
        return totalSum - sum;
    }
}
