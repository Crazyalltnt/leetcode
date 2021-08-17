/**
 * No.34 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/17 10:03
 */
public class L0034FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 目标值起始和结束位置
     */
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false) - 1;
        if (start <= end && end < nums.length && nums[start] == target && nums[end] == target) {
            return new int[] {start, end};
        }
        return new int[] {-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean start) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (start && nums[mid] >= target)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
