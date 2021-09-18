import java.util.LinkedList;
import java.util.Queue;

/**
 * No.958 二叉树的完全性检验
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/17 17:05
 */
public class L0958CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {

    }

    int size = 0;
    int maxIndex = 0;
    /**
     * 二叉树的完全性检验 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param root 根节点
     * @return 是否完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        dfs(root, 1);
        return maxIndex == size;
    }

    public void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        size++;
        maxIndex = Math.max(maxIndex, index);
        dfs(root.left, 2 * index);
        dfs(root.right, 2 * index + 1);
    }

    /**
     * 二叉树的完全性检验 层序
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 是否完全二叉树
     */
    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean reachNull = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                reachNull = true;
            } else {
                if (reachNull) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
