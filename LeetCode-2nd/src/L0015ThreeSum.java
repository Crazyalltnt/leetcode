import java.util.*;
import java.util.List;

/**
 * No.15 3Sum
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/18 10:41
 */
public class L0015ThreeSum {
    public static void main(String[] args) {

    }

    /**
     * 三数之和
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 不重复三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
