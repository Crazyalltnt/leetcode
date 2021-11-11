import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/11 21:01
 */
public class JZ59MaxSlidingWindow1 {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口的最大值
     * 时间复杂度 O(N)
     * 空间复杂度 O(K)
     *
     * @param num 数组
     * @param size 滑动窗口大小
     * @return 滑动窗口里的最大值
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num.length == 0 || size == 0) {
            return new ArrayList<>();
        }
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1 - size, j = 0; j < num.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == num[i - 1]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < num[j]) {
                deque.removeLast();
            }
            deque.addLast(num[j]);
            if (i >= 0) {
                ans.add(deque.peekFirst());
            }
        }
        return ans;
    }
}
