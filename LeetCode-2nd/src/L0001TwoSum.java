import java.util.HashMap;
import java.util.Map;

/**
 * No.1 两数之和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/14 20:03
 */
public class L0001TwoSum {
    public static void main(String[] args) {

    }

    /**
     * 两数之和 暴力
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 两个整数索引
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 两数之和 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 两个整数索引
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[] {hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
