/**
 * No.162 寻找峰值
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/2 16:34
 */
public class L0162FindPeakElement {
    public static void main(String[] args) {

    }

    /**
     * 寻找峰值 线性遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 峰值元素
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }

    /**
     * 寻找峰值 二分查找 递归
     * 时间复杂度 O(logN)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 峰值元素
     */
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        }
        return search(nums, mid + 1, right);
    }

    /**
     * 寻找峰值 二分查找 迭代
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 峰值元素
     */
    public int findPeakElement3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
