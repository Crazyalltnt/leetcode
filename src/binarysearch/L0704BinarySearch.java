package binarysearch;

/**
 * No.704 二分查找
 * https://leetcode-cn.com/problems/binary-search
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/17 9:33
 */
public class L0704BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 7));
    }

    /**
     * 二分查找
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值索引
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
