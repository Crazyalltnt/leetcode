package tree;

import com.sun.javafx.image.BytePixelSetter;

/**
 * No.222 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * 示例 2：
 * 输入：root = []
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 提示：
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 *
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/4 9:30
 */
public class L222CountCompleteTreeNodes {
    public static void main(String[] args) {

    }

    /**
     * 完全二叉树的节点个数 二分查找 位运算
     * 时间复杂度 O((logN)^2)
     * 空间复杂度 O(1)
     *
     * @param root 根结点
     * @return 节点个数
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }

        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    /**
     * 完全二叉树的节点个数 递归
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根结点
     * @return 节点个数
     */
    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
