package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.94 二叉树的中序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/5 10:39
 */
public class L0094BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }


    /**
     * 二叉树的中序遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new LinkedList<>();
        inorderTraversal(root, inorderList);
        return inorderList;
    }

    public void inorderTraversal(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right, inorderList);
    }

    /**
     * 二叉树的中序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inorderList = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorderList.add(root.val);
            root = root.right;
        }
        return inorderList;
    }

    /**
     * 二叉树的中序遍历 Morris
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param root 根结点
     * @return 中序遍历
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> inorderList = new LinkedList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    inorderList.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                inorderList.add(root.val);
                root = root.right;
            }
        }
        return inorderList;
    }
}
