/**
 * No.283 移动零
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/11 21:49
 */
public class L0283MoveZeroes {
    public static void main(String[] args) {

    }

    /**
     * 移动零
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
