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
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        // int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        // int k = 4;
        System.out.println(findKthLargest4(nums, k));
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

    /**
     * 数组中的第K个最大元素 快排
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @param k    次序
     * @return 第k大元素
     */
    public static int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 快速选择
     *
     * @param nums 数组
     * @param left 开始索引
     * @param right 结束索引
     * @param index 第index+1大
     * @return 第index+1大元素
     */
    public static int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    /**
     * 随机分治 返回第i+1个大的数的索引
     *
     * @param nums 数组
     * @param left 开始索引
     * @param right 结束索引
     * @return 随机数索引
     */
    public static int randomPartition(int[] nums, int left, int right){
        int index = (int)(Math.random() * (right - left + 1) + left);
        swap(nums, index, right);

        int x = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            // 将比随机数x大的放在[l,i]之间
            if (nums[j] >= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    /**
     * 交换数组元素
     *
     * @param nums 数组
     * @param i 索引
     * @param j 索引
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 数组中的第K个最大元素 快排
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @param k    次序
     * @return 第k大元素
     */
    public static int findKthLargest4(int[] nums, int k) {
        // 前k个元素建成小根堆
        for (int i = 0; i < k; i++) {
            swim(nums, i);
        }

        // 剩下的元素与堆顶比较，大于则去掉堆顶，再将其插入
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                sink(nums, 0, k - 1);
            }
        }

        return nums[0];
    }

    /**
     * 上浮 从下到上调整堆
     *
     * @param heap 堆
     * @param i 索引
     */
    public static void swim(int[] heap, int i) {
        while (i > 0 && priorityThan(heap[i], heap[(i - 1) / 2])) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 下沉 从下到上调整堆
     *
     * @param heap 堆
     * @param i 索引
     * @param n 边界
     */
    public static void sink(int[] heap, int i, int n) {
        while (2 * i + 1 <= n) {
            int j = 2 * i + 1;
            if (j + 1 <= n && priorityThan(heap[j + 1], heap[j])) {
                j++;
            }
            if (priorityThan(heap[i], heap[j])) {
                break;
            }
            swap(heap, i, j);
            i = j;
        }
    }


    /**
     * v1是否比v2优先度高
     *
     * @param v1 顶点1
     * @param v2 顶点2
     * @return v1比v2优先度高返回true
     */
    private static boolean priorityThan(int v1, int v2) {
        return v1 < v2;
    }
}
