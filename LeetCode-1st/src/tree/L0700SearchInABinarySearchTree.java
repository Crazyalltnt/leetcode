package tree;

import sun.reflect.generics.tree.Tree;

/**
 * No.700 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/2 14:10
 */
public class L0700SearchInABinarySearchTree {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树中的搜索 递归
     * 时间复杂度 O(Height)
     * 空间复杂度 O(Height)
     *
     * @param root 根结点
     * @param val 目标值
     * @return 目标值节点
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 二叉搜索树中的搜索 迭代
     * 时间复杂度 O(Height)
     * 空间复杂度 O(1)
     *
     * @param root 根结点
     * @param val 目标值
     * @return 目标值节点
     */
    public static TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
