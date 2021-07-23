import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.94 二叉树的中序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/23 21:27
 */
public class L0094BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的中序遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    /**
     * 二叉树的中序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
