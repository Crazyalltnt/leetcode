/**
 * No.33 搜索旋转排序数组
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/26 16:06
 */
public class L0033SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 搜索旋转排序数组
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 索引
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[left] <= nums[mid]) {
               if (nums[left] <= target && target < nums[mid]) {
                   right = mid - 1;
               } else {
                   left = mid + 1;
               }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
