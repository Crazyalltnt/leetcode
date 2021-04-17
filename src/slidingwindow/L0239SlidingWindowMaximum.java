package slidingwindow;

import java.util.*;

/**
 * No.239 滑动窗口最大值
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/17 14:03
 */
public class L0239SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * 滑动窗口最大值 优先队列
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param nums 整数数组
     * @param k 滑动窗口大小
     * @return 最大值数组
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            maxQueue.offer(new int[] {nums[i], i});
        }

        int[] res = new int[nums.length - k + 1];
        assert maxQueue.peek() != null;
        res[0] = maxQueue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            maxQueue.offer(new int[] {nums[i], i});
            while (maxQueue.peek() != null && maxQueue.peek()[1] <= i - k) {
                maxQueue.poll();
            }
            assert maxQueue.peek() != null;
            res[i - k + 1] = maxQueue.peek()[0];
        }
        return res;
    }

    /**
     * 滑动窗口最大值 单调队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(K)
     *
     * @param nums 整数数组
     * @param k 滑动窗口大小
     * @return 最大值数组
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    /**
     * 滑动窗口最大值 分块 + 预处理
     * 时间复杂度 O(N)
     * 空间复杂度 O(K)
     *
     * @param nums 整数数组
     * @param k 滑动窗口大小
     * @return 最大值数组
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
