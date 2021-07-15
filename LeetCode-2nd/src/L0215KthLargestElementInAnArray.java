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
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
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
     * 数组中的第K个最大元素 优先队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
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

    /**
     * 数组中的第K个最大元素 快速排序
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @param k 整数
     * @return 第k大元素
     */
    public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[index];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int index = (int)(Math.random() * (right - left + 1)) + left;
        swap(nums, index, right);

        int x = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] >= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 数组中的第K个最大元素 快速排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @param k 整数
     * @return 第k大元素
     */
    public int findKthLargest4(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            up(nums, i);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                down(nums, 0, k - 1);
            }
        }
        return nums[0];
    }

    public void up(int[] nums, int index) {
        int father = (index - 1) / 2;
        while (father >= 0 && nums[father] > nums[index]) {
            swap(nums, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }

    public void down(int[] nums, int index, int boundary) {
        int son = index * 2 + 1;
        while (son <= boundary) {
            if (son + 1 <= boundary && nums[son + 1] < nums[son]) {
                son++;
            }
            if (nums[index] <= nums[son]) {
                break;
            }
            swap(nums, index, son);
            index = son;
            son = index * 2 + 1;
        }
    }
}
