import java.util.*;

/**
 * No.103 二叉树的锯齿形层序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/20 16:43
 */
public class L0103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的锯齿形层序遍历 栈双端
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 遍历结果
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        boolean direction = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                if (direction) {
                    TreeNode node = deque.pollFirst();
                    level.add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    level.add(node.val);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
            }
            direction = !direction;
            ans.add(level);
        }
        return ans;
    }

    /**
     * 二叉树的锯齿形层序遍历 层双端
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 遍历结果
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        boolean direction = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (direction) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            direction = !direction;
            ans.add(new LinkedList<>(level));
        }
        return ans;
    }
}
