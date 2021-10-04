package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.739 每日温度
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/4 14:40
 */
public class L0739DailyTemperatures {
    public static void main(String[] args) {

    }

    /**
     * 每日温度 暴力
     * 时间复杂度 O(MN)
     * 空间复杂度 O(N)
     *
     * @param temperatures 温度数组
     * @return 等待时间数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; t++) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }

    /**
     * 每日温度 单调栈
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param temperatures 温度数组
     * @return 等待时间数组
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
