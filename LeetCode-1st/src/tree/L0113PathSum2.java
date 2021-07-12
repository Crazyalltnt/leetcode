package tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * No.113 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/16 14:16
 */
public class L0113PathSum2 {
    public static void main(String[] args) {

    }


    /**
     * 路径总和 II 深度优先搜索
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @param targetSum 目标值
     * @return 路径列表
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, res);
        return res;
    }
    static List<Integer> path = new ArrayList<>();
    public static void pathSum(TreeNode root, int targetSum, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(path));
        }
        pathSum(root.left, targetSum - root.val, res);
        pathSum(root.right, targetSum - root.val, res);
        path.remove(path.size() - 1);
    }
}
