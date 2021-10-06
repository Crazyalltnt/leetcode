import java.util.Deque;
import java.util.LinkedList;

/**
 * No.739 每日温度
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/6 15:35
 */
public class L0739DailyTemperatures {
    public static void main(String[] args) {

    }

    /**
     * 每日温度 栈
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param temperatures 温度数组
     * @return 等待天数
     */
    public int[] dailyTemperatures(int[] temperatures){
        int len = temperatures.length;
        int[] warmer = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                warmer[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return warmer;
    }
}
