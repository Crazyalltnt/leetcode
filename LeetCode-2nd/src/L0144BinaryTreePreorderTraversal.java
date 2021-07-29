import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.144 二叉树的前序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/29 15:56
 */
public class L0144BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的前序遍历 递归 深度优先搜索
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    /**
     * 二叉树的前序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 前序遍历
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }
}
