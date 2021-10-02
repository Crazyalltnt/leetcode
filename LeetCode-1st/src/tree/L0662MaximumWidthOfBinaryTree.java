package tree;

import javafx.util.Pair;

import java.util.*;

/**
 * No.662 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 *
 * 示例 2:
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 *
 * 示例 3:
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 *
 * 示例 4:
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 *
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/2 19:45
 */
public class L0662MaximumWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 二叉树最大宽度 广度优先搜索 层序遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 最大宽度
     */
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode tmp = queue.poll();
            if (tmp.node != null) {
                queue.add(new AnnotatedNode(tmp.node.left, tmp.depth + 1, tmp.pos * 2));
                queue.add(new AnnotatedNode(tmp.node.right, tmp.depth + 1, tmp.pos * 2 + 1));
                if (curDepth != tmp.depth) {
                    curDepth = tmp.depth;
                    left = tmp.pos;
                }
                ans = Math.max(ans, tmp.pos - left + 1);
            }
        }
        return ans;
    }

    int ans;
    Map<Integer, Integer> left;
    /**
     * 二叉树最大宽度 深度优先搜索 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 最大宽度
     */
    public int widthOfBinaryTree2(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        left.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }

    /**
     * 二叉树最大宽度 广度优先搜索 层序遍历2
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 最大宽度
     */
    public int widthOfBinaryTree3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        deque.add(new Pair<>(root, 0));
        while (!deque.isEmpty()) {
            ans = Math.max(ans, deque.peekLast().getValue() - deque.peekFirst().getValue() + 1);
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                Pair<TreeNode, Integer> tmpPair = deque.pollFirst();
                TreeNode node = tmpPair.getKey();
                int pos = tmpPair.getValue();
                if (node.left != null) {
                    deque.offerLast(new Pair<>(node.left, pos * 2));
                }
                if (node.right != null) {
                    deque.offerLast(new Pair<>(node.right, pos * 2 + 1));
                }
            }
        }
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}
