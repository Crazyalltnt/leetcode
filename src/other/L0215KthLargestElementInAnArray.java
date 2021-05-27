package other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * No.215 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/27 16:31
 */
public class L0215KthLargestElementInAnArray {
    public static void main(String[] args) {
        // int[] nums = {3, 2, 1, 5, 6, 4};
        // int k = 2;

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    /**
     * 数组中的第K个最大元素
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param nums 数组
     * @param k    次序
     * @return 第k大元素
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 数组中的第K个最大元素 优先队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @param k    次序
     * @return 第k大元素
     */
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k || num > queue.peek()) {
                queue.offer(num);
            }

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
