import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 68 - I. 二叉树的最近公共祖先
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/6 14:02
 */
public class JZ68LowestCommonAncestor1 {
    public static void main(String[] args) {

    }

    int ans;
    /**
     * 二叉搜索树的最近公共祖先 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param o1 节点1
     * @param o2 节点2
     * @return 最近公共祖先
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        dfs(root, o1, o2);
        return ans;
    }

    public boolean dfs(TreeNode root, int o1, int o2) {
        if (root == null) {
            return false;
        }

        boolean leftSon = dfs(root.left, o1, o2);
        boolean rightSon = dfs(root.right, o1, o2);
        if ((leftSon && rightSon) || (root.val == o1 || root.val == o2) && (leftSon || rightSon)) {
            ans = root.val;
        }
        return leftSon || rightSon || root.val == o1 || root.val == o2;
    }

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    /**
     * 二叉搜索树的最近公共祖先 存储父节点
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param o1 节点1
     * @param o2 节点2
     * @return 最近公共祖先
     */
    public int lowestCommonAncestor2(TreeNode root, int o1, int o2) {
        dfs(root);
        visited.add(o1);
        TreeNode p = parent.get(o1);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        if (visited.contains(o2)) {
            return o2;
        }
        TreeNode q = parent.get(o2);
        while (q != null) {
            if (visited.contains(q.val)) {
                return q.val;
            }
            q = parent.get(q.val);
        }
        return 0;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    /**
     * 二叉树的最近公共祖先 递归优化
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param root 根结点
     * @param o1 节点1
     * @param o2 节点2
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, int o1, int o2) {
        if (root == null) {
            return null;
        }
        if (root.val == o1 || root.val == o2) {
            return root;
        }

        TreeNode left = lowestCommonAncestor3(root.left, o1, o2);
        TreeNode right = lowestCommonAncestor3(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
