package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.102 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/30 17:02
 */
public class L0102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的层序遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 节点值列表
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodeList = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                nodeList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            list.add(nodeList);
        }
        return list;
    }
}
