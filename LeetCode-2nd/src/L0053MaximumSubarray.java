import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * No.53 最大子序和
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/17 23:03
 */
public class L0053MaximumSubarray {
    public static void main(String[] args) {

    }

    /**
     * 最大子序和 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 子数组
     */
    public int maxSubArray(int[] nums) {
        int curMax = 0, ans = nums[0];
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            ans = Math.max(ans, curMax);
        }
        return ans;
    }

    class Status {
        private int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    /**
     * 最大子序和 分治法
     * 时间复杂度 O(N)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 子数组
     */
    public int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] nums, int left, int right) {
        if (left == right) {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }

        int mid = left + (right - left) / 2;
        Status leftSub = getInfo(nums, left, mid);
        Status rightSub = getInfo(nums, mid + 1, right);
        return pushUp(leftSub, rightSub);
    }

    private Status pushUp(Status leftSub, Status rightSub) {
        int iSum = leftSub.iSum + rightSub.iSum;
        int lSum = Math.max(leftSub.lSum, leftSub.iSum + rightSub.lSum);
        int rSum = Math.max(rightSub.rSum, rightSub.iSum + leftSub.rSum);
        int mSum = Math.max(Math.max(leftSub.mSum, rightSub.mSum), leftSub.rSum + rightSub.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
