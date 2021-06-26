package tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.105 从前序与中序遍历序列构造二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/26 16:12
 */
public class L0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

    }

    private Map<Integer, Integer> indexMap;
    /**
     * 从前序与中序遍历序列构造二叉树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根结点
        // 在中序遍历中定位根结点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);

        // 先把根结点建立出来
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        // 递归构建左子树，并连接到根结点
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
        // 递归构建右子树，并连接到根结点
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1, inorderRight);

        return root;
    }

    /**
     * 从前序与中序遍历序列构造二叉树 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树
     */
    public TreeNode buildTre2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
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
