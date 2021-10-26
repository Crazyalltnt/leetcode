import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 28. 对称的二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/26 9:50
 */
public class JZ28IsSymmertric {
    public static void main(String[] args) {

    }


    /**
     * 对称的二叉树 深度优先搜索 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @return 是否对称
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || dfs(pRoot.left, pRoot.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    /**
     * 对称的二叉树 深度优先搜索 非递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @return 是否对称
     */
    public boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    /**
     * 对称的二叉树 广度优先搜索 非递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @return 是否对称
     */
    public boolean isSymmetrical3(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
