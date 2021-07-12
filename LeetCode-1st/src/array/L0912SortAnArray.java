package array;

import java.util.Arrays;

/**
 * No.912 排序数组
 * https://leetcode-cn.com/problems/sort-an-array
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/13 10:12
 */
public class L0912SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        // int[] nums = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    /**
     * 排序数组 快速排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 排序
     */
    public static int[] sortArray(int[] nums) {
        randomizedQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void randomizedQuickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = randomizedPartition(nums, left, right);
            randomizedQuickSort(nums, left, pos - 1);
            randomizedQuickSort(nums, pos + 1, right);
        }
    }

    public static int randomizedPartition(int[] nums, int left, int right) {
        int index = (int)(Math.random() * (right - left + 1)) + left;
        swap(nums, index, right);

        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 排序数组 堆排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 排序
     */
    public static int[] sortArray2(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public static void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; i--) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public static void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }

    public static void maxHeapify(int[] nums, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int leftSon = (i << 1) + 1;
            int rightSon = (i << 1) + 2;
            int large;

            if (leftSon <= len && nums[leftSon] > nums[i]) {
                large = leftSon;
            } else {
                large = i;
            }

            if (rightSon <= len && nums[rightSon] > nums[large]) {
                large = rightSon;
            }

            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    /**
     * 排序数组 归并排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param nums 数组
     * @return 排序
     */
    public static int[] sortArray3(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tmp);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);
        int i = left, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= right) {
            tmp[cnt++] = nums[j++];
        }
        if (right - left + 1 >= 0) {
            System.arraycopy(tmp, 0, nums, left, right - left + 1);
        }
    }
}
