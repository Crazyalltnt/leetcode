package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.144 二叉树的前序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/24 9:30
 */
public class L0144BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的前序遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 前序遍历列表
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        preOrder(root, ans);
        return ans;
    }

    public void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    /**
     * 二叉树的前序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 前序遍历列表
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }

    /**
     * 二叉树的前序遍历 Morris遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param root 根结点
     * @return 前序遍历列表
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        TreeNode p1 = root, p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }

                if (p2.right == null) {
                    ans.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                ans.add(p1.val);
            }
            p1 = p1.right;
        }
        return ans;
    }
}
