import javafx.util.Pair;

import java.util.*;

/**
 * No.662 二叉树最大宽度
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/5 20:26
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
        if (root == null) {
            return 0;
        }

        Queue<WrappedNode> queue = new LinkedList<>();
        queue.offer(new WrappedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            WrappedNode tmpNode = queue.poll();
            if (tmpNode.node != null) {
                queue.offer(new WrappedNode(tmpNode.node.left, tmpNode.depth + 1, tmpNode.pos * 2));
                queue.offer(new WrappedNode(tmpNode.node.right, tmpNode.depth + 1, tmpNode.pos * 2 + 1));
                if (curDepth != tmpNode.depth) {
                    curDepth = tmpNode.depth;
                    left = tmpNode.pos;
                }
                ans = Math.max(ans, tmpNode.pos - left + 1);
            }
        }
        return ans;
    }

    /**
     * 二叉树最大宽度 广度优先搜索 层序遍历2
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 最大宽度
     */
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        deque.offerLast(new Pair<>(root, 0));
        int ans = 0;
        while (!deque.isEmpty()) {
            ans = Math.max(ans, deque.peekLast().getValue() - deque.peekFirst().getValue() + 1);
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                Pair<TreeNode, Integer> tmp = deque.pollFirst();
                TreeNode node = tmp.getKey();
                int pos = tmp.getValue();
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

    int ans;
    Map<Integer, Integer> left;
    /**
     * 二叉树最大宽度 广度优先搜索 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 最大宽度
     */
    public int widthOfBinaryTree3(TreeNode root) {
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
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }
}

class WrappedNode {
    TreeNode node;
    int depth;
    int pos;

    public WrappedNode(TreeNode node, int depth, int pos) {
        this.node = node;
        this.depth = depth;
        this.pos = pos;
    }
}
