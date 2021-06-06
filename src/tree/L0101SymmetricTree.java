package tree;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.101 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/6 9:45
 */
public class L0101SymmetricTree {
    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        System.out.println(queue.size());
        System.out.println(queue.poll());
    }

    /**
     * 对称二叉树 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return check(root.left, root.right);
        }
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 对称二叉树 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @return 是否对称
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return check2(root.left, root.right);
        }
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
