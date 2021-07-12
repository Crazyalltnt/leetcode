package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * No.199 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/22 10:30
 */
public class L0199BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的右视图 层序遍历 广度优先搜素
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 节点列表
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new LinkedList<>();
        if (root == null) {
            return rightViewList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curNode = queue.poll();
                if (size == 1) {
                    rightViewList.add(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                size--;
            }
        }
        return rightViewList;
    }

    /**
     * 二叉树的右视图 前序遍历修改（根->右-左） 深度优先搜索
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 节点列表
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rightViewList = new LinkedList<>();
        dfs(root, 0, rightViewList);

        return rightViewList;
    }

    public void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (depth == list.size()) {
            list.add(root.val);
        }
        depth++;
        dfs(root.right, depth, list);
        dfs(root.left, depth, list);
    }
}
