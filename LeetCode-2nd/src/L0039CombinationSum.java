import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.39 组合总和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/15 17:00
 */
public class L0039CombinationSum {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    /**
     * 组合总和 回溯
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param candidates 数组
     * @param target 目标值
     * @return 组合集合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return ans;
    }

    public void backtrack(int[] candidates, int begin, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
