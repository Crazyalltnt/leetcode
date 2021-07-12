package tree;

/**
 * No.450 删除二叉搜索树中的节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/2 14:43
 */
public class L0450DeleteNodeInABST {
    public static void main(String[] args) {

    }

    /**
     * 删除二叉搜索树中的节点
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根节点
     * @param key 待删除节点值
     * @return 新的根节点
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        // 从右子树删除
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // 从左子树删除
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // 删除当前节点
        else {
            // 如果是叶子节点
            if (root.left == null && root.right == null) {
                root = null;
            }
            // 如果是非叶子节点且有右子树
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // 如果是非叶子节点且有左子树
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * 寻找右子树最小节点 中序后继节点
     *
     * @param root 当前节点
     * @return 右子树最小节点值
     */
    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 寻找左子树最大节点 中序前驱节点
     *
     * @param root 当前节点
     * @return 右子树最小节点值
     */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
