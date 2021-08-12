import java.util.LinkedList;
import java.util.Queue;

/**
 * No.112 路径总和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/12 21:40
 */
public class L0112PathSum {
    public static void main(String[] args) {

    }

    /**
     * 路径总和 深度优先搜索 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根节点
     * @param targetSum 目标和
     * @return 是否存在路径
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 路径总和 广度优先搜索
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param targetSum 目标和
     * @return 是否存在路径
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> pathSumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathSumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int tempPathSum = pathSumQueue.poll();
            if (node.left == null && node.right == null) {
                if (tempPathSum == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                pathSumQueue.offer(node.left.val + tempPathSum);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathSumQueue.offer(node.right.val + tempPathSum);
            }
        }
        return false;
    }
}
