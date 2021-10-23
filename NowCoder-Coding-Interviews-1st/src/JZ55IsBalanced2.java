/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/16 10:39
 */
public class JZ55IsBalanced2 {
    public static void main(String[] args) {

    }

    /**
     * 平衡二叉树 递归 自顶向下
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getDepth(root.right) - getDepth(root.left)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    /**
     * 平衡二叉树 递归 自底向上
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth2(root) >= 0;
    }

    public int getDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth, rightDepth;
        if ((leftDepth = getDepth2(root.left)) == - 1 || (rightDepth = getDepth2(root.right)) == -1|| Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
