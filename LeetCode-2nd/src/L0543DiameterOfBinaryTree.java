/**
 * No.543 二叉树的直径
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/3 23:39
 */
public class L0543DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    int diameter = 0;
    /**
     * 二叉树的直径
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根节点
     * @return 直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
