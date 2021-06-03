package other;


import java.util.ArrayList;
import java.util.List;

/**
 * N0.78 子集
 * https://leetcode-cn.com/problems/subsets
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/3 10:10
 */
public class L0078Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets2(nums));
    }

    /**
     * 子集 二进制模拟
     * 时间复杂度 O(N * 2^N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子集集合
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> setList = new ArrayList<>();
        int n = nums.length;

        int bitFlag = 0;
        while (bitFlag < Math.pow(2, n)) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((bitFlag >> i) & 1) == 1) {
                    subList.add(nums[i]);
                }
            }
            setList.add(subList);
            bitFlag += 1;
        }
        return setList;
    }

    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static List<Integer> t = new ArrayList<Integer>();

    /**
     * 子集 迭代
     * 时间复杂度 O(N * 2^N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 子集集合
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
