import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/28 10:04
 */
public class JZ31ValidateStackSequences {
    public static void main(String[] args) {

    }

    /**
     * 栈的压入、弹出序列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pushA 序列1
     * @param popA 序列2
     * @return 是否对应
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushA) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 栈的压入、弹出序列
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pushA 序列1
     * @param popA 序列2
     * @return 是否对应
     */
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        int i = 0, j = 0;
        for (int num : pushA) {
            pushA[i] = num;
            while (i >= 0 && pushA[i] ==  popA[j]) {
                j++;
                i--;
            }
            i++;
        }
        return i == 0;
    }
}
