import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径 2
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/5 15:40
 */
public class JZ34PathSum2 {
    public static void main(String[] args) {

    }

    /**
     * 二叉树中和为某一值的路径 深度优先搜索 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N^2)
     *
     * @param root 根节点
     * @param sum 和
     * @return 是否存在
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        return dfs(root.left, target) || dfs(root.right, target);
    }

    /**
     * 二叉树中和为某一值的路径 广度优先搜索
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param sum 和
     * @return 是否存在
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currentSum = sumQueue.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (currentSum == sum) {
                    return true;
                }
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(currentSum);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(currentSum);
            }
        }
        return false;
    }
}
