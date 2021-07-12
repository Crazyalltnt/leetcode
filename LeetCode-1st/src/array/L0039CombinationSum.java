package array;

import java.util.ArrayList;
import java.util.List;

/**
 * No.39 组合总和
 * https://leetcode-cn.com/problems/combination-sum
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/3 18:48
 */
public class L0039CombinationSum {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();
    /**
     * 组合总和
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param candidates 数组
     * @param target 目标数
     * @return 目标组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(subList));
            return;
        }

        dfs(candidates, target, index + 1);

        if (target - candidates[index] >= 0) {
            subList.add(candidates[index]);
            dfs(candidates, target - candidates[index], index);
            subList.remove(subList.size() - 1);
        }
    }
}
