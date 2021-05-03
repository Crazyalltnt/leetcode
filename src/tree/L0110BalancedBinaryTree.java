package tree;

/**
 * No.110 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 *
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/3 10:46
 */
public class L0110BalancedBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 平衡二叉树 自顶向下的递归
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 是否平衡二叉树
     */
    public static boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getHeight1(root.left) - getHeight1(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight1(root.left), getHeight1(root.right)) + 1;
    }

    /**
     * 平衡二叉树 自底向上的递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 是否平衡二叉树
     */
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
