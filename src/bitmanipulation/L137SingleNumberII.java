package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * No.137 只出现一次的数字 II
 * https://leetcode-cn.com/problems/single-number-ii
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/8 10:47
 */
public class L137SingleNumberII {
    public static void main(String[] args) {

    }

    /**
     * 只出现一次的数字 II 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 只出现一次的数字
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int countOfNumber = entry.getValue();
            if (countOfNumber == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    /**
     * 只出现一次的数字 II 依次确定每一个二进制位
     * 时间复杂度 O(NlogC)=O(32*N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 只出现一次的数字
     */
    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
