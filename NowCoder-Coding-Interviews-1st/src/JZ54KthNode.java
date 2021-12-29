/**
 * 剑指 Offer 54. 二叉搜索树的第k小节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/12/29 15:34
 */
public class JZ54KthNode {
    public static void main(String[] args) {

    }

    int res, k;
    /**
     * 二叉搜索树的第k小节点
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param proot 根节点
     * @param k 第k小
     * @return 第k小节点
     */
    public int KthNode(TreeNode proot, int k) {
        if (proot == null || k == 0) {
            return -1;
        }
        this.k = k;
        dfs(proot);
        if (this.k > 0) {
            return -1;
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.right);
    }
}
