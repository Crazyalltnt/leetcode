/**
 * No.110 平衡二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/29 16:43
 */
public class L0110BalancedBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 平衡二叉树 自顶向下
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根结点
     * @return 是否平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * 平衡二叉树 自底向上
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根结点
     * @return 是否平衡二叉树
     */
    public boolean isBalanced2(TreeNode root) {
        return depth2(root) != -1;
    }

    public int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
