/**
 * No.31 下一个排列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/2 16:22
 */
public class L0031NextPermutation {
    public static void main(String[] args) {

    }

    /**
     * 下一个排列
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int begin) {
        int end = nums.length - 1;
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
