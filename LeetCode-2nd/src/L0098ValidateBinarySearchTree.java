import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.98 验证二叉搜索树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/11 19:53
 */
public class L0098ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    /**
     * 验证二叉搜索树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 是否二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    /**
     * 验证二叉搜索树 中序遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 是否二叉搜索树
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> inorderList = new LinkedList<>();
        dfs(root, inorderList);
        for (int i = 0; i < inorderList.size() - 2; i++) {
            if (inorderList.get(i) >= inorderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        dfs(root.left, inorderList);
        inorderList.add(root.val);
        dfs(root.right, inorderList);
    }

    /**
     * 验证二叉搜索树 中序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 是否二叉搜索树
     */
    public boolean isValidBST3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
