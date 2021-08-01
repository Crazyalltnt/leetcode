import java.util.LinkedList;
import java.util.List;

/**
 * No.113 路径总和 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/1 9:09
 */
public class L0113PathSumII {
    public static void main(String[] args) {

    }

    List<List<Integer>> pathList = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    /**
     * 路径总和 II
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @param target 目标值
     * @return 路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return pathList;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            pathList.add(new LinkedList<>(path));
        }

        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
        path.remove(path.size() - 1);
    }
}
