import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.105 从前序与中序遍历序列构造二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/1 10:08
 */
public class L0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> indexMap;
    /**
     * 从前序与中序遍历序列构造二叉树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树根结点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderBegin, int preorderEnd, int inorderBegin, int inorderEnd) {
        if (preorderEnd < preorderBegin) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderBegin]);
        int rootIndexOfInorder = indexMap.get(preorder[preorderBegin]);

        root.left = buildTree(preorder, inorder, preorderBegin + 1, preorderBegin + rootIndexOfInorder - inorderBegin, inorderBegin, rootIndexOfInorder - 1);
        root.right = buildTree(preorder, inorder, preorderBegin + rootIndexOfInorder - inorderBegin + 1, preorderEnd, rootIndexOfInorder + 1, inorderEnd);
        return root;
    }

    /**
     * 从前序与中序遍历序列构造二叉树 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(H)
     *
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树根结点
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val == inorder[inorderIndex]) {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            } else {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}
