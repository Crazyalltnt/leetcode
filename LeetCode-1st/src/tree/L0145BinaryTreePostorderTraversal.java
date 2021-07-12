package tree;

import java.util.*;

/**
 * No.145 二叉树的后序遍历
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/8 16:10
 */
public class L0145BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }

    List<Integer> list = new LinkedList<>();
    /**
     * 二叉树的后序遍历 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        list.add(node.val);
    }

    /**
     * 二叉树的后序遍历 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 后序遍历
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                // 如果右子树为空或者已经访问过了才访问根结点
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                // 否则，需要将该结点再次压回栈中，去访问其右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 二叉树的后序遍历 迭代2
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 后序遍历
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 二叉树的后序遍历 Morris遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param root 根结点
     * @return 后序遍历
     */
    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }
}
