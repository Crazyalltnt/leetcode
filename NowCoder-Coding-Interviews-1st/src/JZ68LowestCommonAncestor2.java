import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 68 - II. 二叉搜索树的最近公共祖先
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/11 10:10
 */
public class JZ68LowestCommonAncestor2 {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树的最近公共祖先 两次遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param p 节点1
     * @param q 节点2
     * @return 最近公共祖先
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor.val;
    }

    public List<TreeNode> getPath(TreeNode root, int target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node.val != target) {
            path.add(node);
            if (target < node.val) {
                node = node.left;
            }
             else {
                 node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    /**
     * 二叉搜索树的最近公共祖先 一次遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param root 根节点
     * @param p 节点1
     * @param q 节点2
     * @return 最近公共祖先
     */
    public int lowestCommonAncestor2(TreeNode root, int p, int q) {
        TreeNode ancestor = root;
        while (true) {
            if (p < ancestor.val && q < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p > ancestor.val && q > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor.val;
    }

    /**
     * 二叉搜索树的最近公共祖先 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param p 节点1
     * @param q 节点2
     * @return 最近公共祖先
     */
    public int lowestCommonAncestor3(TreeNode root, int p, int q) {
        if (root.val < p && root.val < q) {
            return lowestCommonAncestor3(root.right, p, q);
        } else if (root.val > p && root.val > q) {
            return lowestCommonAncestor3(root.left, p, q);
        }
        return root.val;
    }
}
