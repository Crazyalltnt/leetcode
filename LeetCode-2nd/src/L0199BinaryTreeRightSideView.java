import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.199 二叉树的右视图
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/26 19:41
 */
public class L0199BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的右视图 广度优先搜索
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 右视图
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (size == 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return ans;
    }

    /**
     * 二叉树的右视图 深度优先搜索
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 右视图
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        dfs(node.right, depth + 1, ans);
        dfs(node.left, depth + 1, ans);
    }
}
