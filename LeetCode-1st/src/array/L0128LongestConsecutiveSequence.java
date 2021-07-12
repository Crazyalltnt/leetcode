package array;

import java.util.HashSet;
import java.util.Set;

/**
 * No.128 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/9 22:20
 */
public class L0128LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    /**
     * 最长连续序列 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 最长序列的长度
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;

                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    curLength += 1;
                }

                longest = Math.max(longest, curLength);
            }
        }
        return longest;
    }
}
