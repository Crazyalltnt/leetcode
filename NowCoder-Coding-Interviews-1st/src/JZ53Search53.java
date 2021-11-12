/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/12 16:11
 */
public class JZ53Search53 {
    public static void main(String[] args) {

    }

    /**
     * 在排序数组中查找数字 I
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @param k 目标值
     * @return 次数
     */
    public int GetNumberOfK(int[] array, int k) {
        int leftIndex = binarySearch(array, k, true);
        int rightIndex = binarySearch(array, k, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < array.length && array[leftIndex] == k && array[rightIndex] == k) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean start) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (start && nums[mid] >= target)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 在排序数组中查找数字 I
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @param k 目标值
     * @return 次数
     */
    public int GetNumberOfK2(int[] array, int k) {
        return helper(array, k) - helper(array, k - 1);
    }

    public int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
