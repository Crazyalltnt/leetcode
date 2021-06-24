package tree;

/**
 * No.543 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/24 12:34
 */
public class L0543DiameterOfBinaryTree {
    public static void main(String[] args) {

    }

    int ans = 0;

    /**
     * 二叉树的直径
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根结点
     * @return 直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
