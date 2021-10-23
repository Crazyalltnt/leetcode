import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/16 10:02
 */
public class JZ55MaxDepth1 {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的深度 深度优先遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根节点
     * @return 二叉树深度
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    /**
     * 二叉树的深度 广度优先遍历 层序
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根节点
     * @return 二叉树深度
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans++;
        }
        return ans;
    }
}
