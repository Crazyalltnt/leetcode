/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/22 15:22
 */
public class JZMirrorTree {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的镜像 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pRoot 根节点
     * @return 镜像
     */
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode tmp = pRoot.left;
        pRoot.left = Mirror(pRoot.right);
        pRoot.right = Mirror(tmp);
        return pRoot;
    }

}
