import java.util.LinkedList;
import java.util.Queue;

/**
 * No.104 二叉树的最大深度
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/30 22:45
 */
public class L0104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的最大深度 深度优先遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根结点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 二叉树的最大深度 广度优先遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 最大深度
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
