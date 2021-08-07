import java.util.LinkedList;
import java.util.Queue;

/**
 * No.101 对称二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/7 21:58
 */
public class L0101SymmetricTree {
    public static void main(String[] args) {

    }

    /**
     * 对称二叉树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param root 根节点
     * @return 是否镜像对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        return leftTree.val == rightTree.val && isSymmetric(leftTree.left, rightTree.right) && isSymmetric(leftTree.right, rightTree.left);
    }

    /**
     * 对称二叉树
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根节点
     * @return 是否镜像对称
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root.left);
        nodeQueue.offer(root.right);
        TreeNode leftNode, rightNode;
        while (!nodeQueue.isEmpty()) {
            leftNode = nodeQueue.poll();
            rightNode = nodeQueue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            nodeQueue.offer(leftNode.left);
            nodeQueue.offer(rightNode.right);
            nodeQueue.offer(leftNode.right);
            nodeQueue.offer(rightNode.left);
        }
        return true;
    }
}
