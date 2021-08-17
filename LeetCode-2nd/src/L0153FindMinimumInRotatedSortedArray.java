/**
 * No.153 寻找旋转排序数组中的最小值
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/17 13:14
 */
public class L0153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(findMin(nums));
    }

    /**
     * 寻找旋转排序数组中的最小值 二分查找
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 最小值
     */
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int ansIndex = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                ansIndex = mid;
                right = mid - 1;
            }
        }
        return nums[ansIndex];
    }

    /**
     * 寻找旋转排序数组中的最小值 二分查找
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 最小值
     */
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
