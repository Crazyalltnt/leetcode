import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/18 10:25
 */
public class JZLevelOrder3 {
    public static void main(String[] args) {

    }

    /**
     * 从上到下打印二叉树 III 之字形打印 栈双端
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @return 打印结果
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        int direction = 1;
        deque.offerLast(pRoot);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                 if (direction == 1) {
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
            ans.add(level);
            direction = -direction;
        }
        return ans;
    }

    /**
     * 从上到下打印二叉树 III 之字形打印 层双端
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @return 打印结果
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }

        int direction = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new ArrayDeque<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (direction == 1) {
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
            direction = -direction;
            ans.add(new ArrayList<>(level));
        }
        return ans;
    }
}
