import java.util.LinkedList;
import java.util.Queue;

/**
 * No.226 翻转二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/6 23:03
 */
public class L0226InvertBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 翻转二叉树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 翻转后的二叉树
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

    /**
     * 翻转二叉树 层序遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 翻转后的二叉树
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                nodeQueue.offer(node.left);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
            }
        }
        return root;
    }
}
