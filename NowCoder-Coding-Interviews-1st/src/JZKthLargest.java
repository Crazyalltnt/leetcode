/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/20 14:45
 */
public class JZKthLargest {
    public static void main(String[] args) {

    }

    int index = 0;
    TreeNode res;
    /**
     * 二叉搜索树的第K大节点
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @param k 第k大
     * @return 第k大节点
     */
    TreeNode KthNode(TreeNode pRoot, int k){
        dfs(pRoot, k);
        return res;
    }

    void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.right, k);
        index++;
        if (k == index) {
            res = root;
        }
        dfs(root.left, k);
    }
}
