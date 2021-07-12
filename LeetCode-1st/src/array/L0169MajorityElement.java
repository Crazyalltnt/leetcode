package array;

import java.util.Arrays;

/**
 * No.169 多数元素
 * https://leetcode-cn.com/problems/majority-element
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/28 23:18
 */
public class L0169MajorityElement {
    public static void main(String[] args) {

    }

    /**
     * 多数元素 位运算
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 多数数组
     */
    public int majorityElement(int[] nums) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bitSum = 0;
            for (int num : nums) {
                bitSum += (num >> i) & 1;
            }
            System.out.println("bitSum = " + bitSum);
            int bit = bitSum > nums.length / 2 ? 1 : 0;
            System.out.println("bit = " + bit);
            ans = (ans * 2) + bit;
            System.out.println("ans = " + ans);
        }
        return ans;
    }

    /**
     * 多数元素 排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 多数数组
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 多数元素 分治
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 多数数组
     */
    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count ++;
            }
        }
        return count;
    }

    public int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (high - low) / 2 + low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, high);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    /**
     * 多数元素 Boyer-Moore投票算法
     * 时间复杂度 O(Nl)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 多数数组
     */
    public int majorityElement4(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
