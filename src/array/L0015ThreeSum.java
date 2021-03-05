package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/5 14:07
 */
public class L0015ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 三数之和
     *
     * @param nums 数组
     * @return 索引列表
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            int target = -nums[first];
            int second = first + 1;
            int third = nums.length - 1;

            if (nums[first] > 0) {
                break;
            }

            if (first == 0 || nums[first] != nums[first - 1]) {
                while (second < third) {
                    if (nums[second] + nums[third] == target) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                        while (second < third && nums[second] == nums[second + 1]) {
                            second++;
                        }

                        while (second < third && nums[third] == nums[third - 1]) {
                            third--;
                        }

                        second++;
                        third--;
                    } else if (nums[second] + nums[third] < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
            }
        }
        return result;
    }
}
