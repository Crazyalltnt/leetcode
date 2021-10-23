import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/23 14:23
 */
public class JZ33VerifyPostorder {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树的后序遍历序列 递归分治
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param sequence 序列
     * @return 是否二叉搜索树
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return recur(sequence, 0, sequence.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    /**
     * 二叉搜索树的后序遍历序列 辅助单调栈
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param sequence 序列
     * @return 是否二叉搜索树
     */
    public boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = sequence.length - 1; i >= 0; i--) {
             if (sequence[i] > root) {
                 return false;
             }
             while (!stack.isEmpty() && stack.peek() > sequence[i]) {
                 root = stack.pop();
             }
             stack.push(sequence[i]);
        }
        return true;
    }
}
