import java.util.*;

/**
 * No.239 滑动窗口最大值
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/12 15:59
 */
public class L0239SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口最大值 优先队列 超时
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @param k 滑动窗口大小
     * @return 滑动窗口最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        list.add(queue.peek());
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i - k]);
            queue.offer(nums[i]);
            list.add(queue.peek());
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 滑动窗口最大值 优先队列 优化
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @param k 滑动窗口大小
     * @return 滑动窗口最大值
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[] {nums[i], i});
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[] {nums[i], i});
            while (queue.peek() != null && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    /**
     * 滑动窗口最大值 单调队列
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(K)
     *
     * @param nums 数组
     * @param k 滑动窗口大小
     * @return 滑动窗口最大值
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.peekLast();
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
     * 空间复杂度 O(N)
     *
     * @param nums 整数数组
     * @param k 滑动窗口大小
     * @return 最大值数组
     */
    public static int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        // **每个分块内** 前缀最大值和后缀最大值
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
