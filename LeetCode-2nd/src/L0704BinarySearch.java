/**
 * No.704 二分查找
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/22 10:17
 */
public class L0704BinarySearch {
    public static void main(String[] args) {

    }

    /**
     * 二分查找
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 索引
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
