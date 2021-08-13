/**
 * No.136 只出现一次的数字
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/13 23:38
 */
public class L0136SingleNumber {
    public static void main(String[] args) {

    }

    /**
     * 只出现一次的数字
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 只出现一次的元素
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
