package tree;

/**
 * No.226 翻转二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/30 19:32
 */
public class L0226InvertBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 翻转二叉树
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 新二叉树根结点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
