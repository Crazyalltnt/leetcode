import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * No.46 全排列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/22 10:36
 */
public class L0046Permutations {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] visited;
    /**
     * 全排列
     * 时间复杂度 O(N*N!)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        visited = new boolean[nums.length];
        backtrack(nums);
        return ans;
    }

    public void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new LinkedList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            visited[i] = false;
        }
    }

    /**
     * 全排列
     * 时间复杂度 O(N*N!)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute2(int[] nums) {
        for (int num : nums) {
            path.add(num);
        }
        int n = nums.length;
        backtrack(n, 0);
        return ans;
    }

    public void backtrack(int n, int index) {
        if (index == n) {
            ans.add(new LinkedList<>(path));
        }
        for (int i = index; i < n; i++) {
            Collections.swap(path, index, i);
            backtrack(n, index + 1);
            Collections.swap(path, index, i);
        }
    }
}
