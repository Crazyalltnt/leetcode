import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/15 16:03
 */
public class JZ07BuildTree {
    public static void main(String[] args) {

    }

    /**
     * 重建二叉树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pre 前序遍历数组
     * @param vin 中序遍历数组
     * @return 二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return  reConstruct(pre, vin, 0, pre.length - 1, 0, vin.length - 1);
    }

    public TreeNode reConstruct(int[] pre, int[] vin, int preStart, int preEnd, int vinStart, int vinEnd) {
        if (preStart < 0 || preEnd > pre.length || preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);

        int rootIndexOfVin = vinStart;
        for (int i = vinStart; i <= vinEnd; i++) {
            if (vin[i] == pre[preStart]) {
                rootIndexOfVin = i;
                break;
            }
        }

        root.left = reConstruct(pre, vin, preStart + 1, preStart + rootIndexOfVin - vinStart, vinStart, rootIndexOfVin - 1);
        root.right = reConstruct(pre, vin, preStart + rootIndexOfVin - vinStart + 1, preEnd, rootIndexOfVin + 1, vinEnd);
        return root;
    }

    /**
     * 重建二叉树
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pre 前序遍历数组
     * @param vin 中序遍历数组
     * @return 二叉树
     */
    public TreeNode reConstructBinaryTree2(int[] pre, int[] vin) {
        if (pre == null || pre.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < pre.length; i++) {
            int preorderVal = pre[i];
            TreeNode node = stack.peek();
            if (node.val != vin[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == vin[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
