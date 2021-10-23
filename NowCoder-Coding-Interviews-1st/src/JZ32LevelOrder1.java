import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/22 16:23
 */
public class JZ32LevelOrder1 {
    public static void main(String[] args) {

    }

    /**
     * 从上到下打印二叉树
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param root 根节点
     * @return 打印序列
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return ans;
    }
}
