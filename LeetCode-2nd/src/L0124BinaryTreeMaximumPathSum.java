import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * No.124 二叉树中的最大路径和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/31 16:13
 */
public class L0124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        // Integer[] tree1 = {1, 2, 3};
        // TreeNode root1 = Util.createTree(tree1);
        // System.out.println(maxPathSum(root1));

        // Integer[] tree2 = {-10, 9, 20, null, null, 15, 7};
        // TreeNode root2 = Util.createTree(tree2);
        // System.out.println(maxPathSum(root2));

        // Integer[] tree3 = {1, 2, 5, -5, -7, -1, null, 6, 8, null, null, null, 10};
        // TreeNode root3 = Util.createTree(tree3);
        // System.out.println(maxPathSum(root3));
    }

    int maxSum = Integer.MIN_VALUE;
    /**
     * 二叉树中的最大路径和 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        maxSubtreeSum(root);
        return maxSum;
    }

    public int maxSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxSubtreeSum(root.left), 0);
        int rightSum = Math.max(maxSubtreeSum(root.right), 0);
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    // static int maxSum = Integer.MIN_VALUE;
    // static List<Integer> maxPath = new LinkedList<>();
    //
    // /**
    //  * 二叉树中的最大路径和 递归
    //  * 变种 —— 打印最大路径
    //  * 时间复杂度 O(N)
    //  * 空间复杂度 O(N)
    //  *
    //  * @param root 根节点
    //  * @return 最大路径和
    //  */
    // public static List<Integer> maxPathSum(TreeNode root) {
    //     maxSubtreeSum(root);
    //     System.out.println(maxSum);
    //     return maxPath;
    // }
    //
    // public static maxSubtreeStatus maxSubtreeSum(TreeNode root) {
    //     if (root == null) {
    //         return new maxSubtreeStatus();
    //     }
    //
    //     maxSubtreeStatus leftStatus = maxSubtreeSum(root.left);
    //     maxSubtreeStatus rightStatus = maxSubtreeSum(root.right);
    //     int newMaxSum = root.val + leftStatus.maxSubtreePathSum + rightStatus.maxSubtreePathSum;
    //
    //     if (newMaxSum > maxSum) {
    //         maxSum = newMaxSum;
    //         maxPath = new LinkedList<>(leftStatus.maxSubtreePath);
    //         maxPath.add(root.val);
    //         Collections.reverse(rightStatus.maxSubtreePath);
    //         maxPath.addAll(rightStatus.maxSubtreePath);
    //     }
    //
    //     if (leftStatus.maxSubtreePathSum > rightStatus.maxSubtreePathSum) {
    //         leftStatus.maxSubtreePath.add(root.val);
    //         return new maxSubtreeStatus(root.val + leftStatus.maxSubtreePathSum, leftStatus.maxSubtreePath);
    //     } else {
    //         rightStatus.maxSubtreePath.add(root.val);
    //         return new maxSubtreeStatus(root.val + rightStatus.maxSubtreePathSum, rightStatus.maxSubtreePath);
    //     }
    //
    // }
    //
    // static class maxSubtreeStatus {
    //     int maxSubtreePathSum;
    //     List<Integer> maxSubtreePath;
    //
    //     maxSubtreeStatus() {
    //         maxSubtreePathSum = 0;
    //         maxSubtreePath = new LinkedList<>();
    //     }
    //
    //     maxSubtreeStatus(int maxSubtreePathSum, List<Integer> maxSubtreePath) {
    //         this.maxSubtreePathSum = maxSubtreePathSum;
    //         this.maxSubtreePath = maxSubtreePath;
    //     }
    // }
}
