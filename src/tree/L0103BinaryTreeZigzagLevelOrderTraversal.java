package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.103 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/14 12:16
 */
public class L0103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的锯齿形层序遍历
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根结点
     * @return 节点遍历列表
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }

                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            list.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return list;
    }
}
