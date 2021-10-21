/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/21 9:49
 */
public class JZIsSubStructure {
    public static void main(String[] args) {

    }

    /**
     * 树的子结构
     * 时间复杂度 O(MN)
     * 空间复杂度 O(M)
     *
     * @param root1 根节点1
     * @param root2 根节点2
     * @return 判断子结构
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return (root1 != null && root2 != null) && (recur(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));
    }

    public boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
