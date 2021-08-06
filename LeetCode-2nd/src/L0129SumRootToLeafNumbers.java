import java.util.LinkedList;
import java.util.Queue;

/**
 * No.129 求根节点到叶节点数字之和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/6 22:27
 */
public class L0129SumRootToLeafNumbers {
    public static void main(String[] args) {

    }

    /**
     * 求根节点到叶节点数字之和 深度优先搜索 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 数字之和
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevNumber) {
        if (root == null) {
            return 0;
        }
        int sum = prevNumber * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * 求根节点到叶节点数字之和 广度优先搜索 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 数字之和
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            if (node.left == null && node.right == null) {
                sum += num;
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    numQueue.offer(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    numQueue.offer(num * 10 + node.right.val);
                }
            }
        }
        return sum;
    }
}
