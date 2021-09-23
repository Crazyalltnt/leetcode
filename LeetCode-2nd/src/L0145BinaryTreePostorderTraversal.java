import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.145 二叉树的后序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/23 9:44
 */
public class L0145BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的后序遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 后序遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }

    /**
     * 二叉树的后序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 后序遍历结果
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                // 如果右子树为空或者已经访问过了才访问根结点
                ans.add(root.val);
                prev = root;
                root = null;
            } else {
                // 否则，需要将该结点再次压回栈中，去访问其右子树
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }
}
