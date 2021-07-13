import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * No.215 数组中的第K个最大元素
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/12 10:46
 */
public class L0215KthLargestElementInAnArray {
    public static void main(String[] args) {

    }

    /**
     * 数组中的第K个最大元素 内置函数
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param nums 数组
     * @param k 整数
     * @return 第k大元素
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 数组中的第K个最大元素 内置函数
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param nums 数组
     * @param k 整数
     * @return 第k大元素
     */
    public int findKthLargest2(int[] nums, int k) {
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
