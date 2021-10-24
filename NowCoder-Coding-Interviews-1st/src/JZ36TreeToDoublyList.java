/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/24 14:25
 */
public class JZ36TreeToDoublyList {
    public static void main(String[] args) {

    }

    TreeNode pre, head;
    /**
     * 二叉搜索树与双向链表
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param pRootOfTree 根节点
     * @return 双向链表
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs(pRootOfTree);
        return head;
    }

    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
