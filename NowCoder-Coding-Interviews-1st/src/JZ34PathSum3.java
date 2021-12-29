/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径 3
 *
 * @author Neil
 * @version v1.0
 * @date 2021/12/29 21:46
 */
public class JZ34PathSum3 {
    public static void main(String[] args) {

    }

    int ans = 0;
    /**
     * 二叉树中和为某一值的路径 深度优先搜索 两次递归
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root  根节点
     * @param sum 和
     * @return 路径数量
     */
    public int FindPath (TreeNode root, int sum) {
        if (root == null) {
            return ans;
        }
        dfs(root, sum);
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return ans;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            ans++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
