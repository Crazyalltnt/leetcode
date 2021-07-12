package array;

import java.util.*;

/**
 * No.46 全排列
 * https://leetcode-cn.com/problems/permutations
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/18 22:46
 */
public class L0046Permutations {
    public static void main(String[] args) {

    }

    /**
     * 全排列 回溯
     * 时间复杂度 O(N*N!)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();

        for (int num : nums) {
            permuteList.add(num);
        }
        int n = nums.length;
        backtrack(n, 0, ans, permuteList);
        return ans;
    }

    public void backtrack(int n, int index, List<List<Integer>> ans, List<Integer> permuteList) {
        if (index == n) {
            ans.add(new ArrayList<>(permuteList));
        }

        for (int i = index; i < n; i++) {
            // 动态维护数组
            Collections.swap(permuteList, index, i);
            // 继续递归填下一个数
            backtrack(n, index + 1, ans, permuteList);
            // 撤销操作
            Collections.swap(permuteList, index, i);
        }
    }
}
