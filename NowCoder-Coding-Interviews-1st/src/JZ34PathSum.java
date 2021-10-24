import java.util.*;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/23 16:34
 */
public class JZ34PathSum {
    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    /**
     * 二叉树中和为某一值的路径 深度优先搜索 递归
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param expectNumber 目标值
     * @return 路径
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        dfs(root, expectNumber);
        return ans;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }


    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();
    /**
     * 二叉树中和为某一值的路径 广度优先搜索
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param root 根节点
     * @param expectNumber 目标值
     * @return 路径
     */
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int expectNumber) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == expectNumber) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new ArrayList<>(temp));
    }
}
