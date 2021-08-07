import java.util.Arrays;

/**
 * No.169 多数元素
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/7 23:08
 */
public class L0169MajorityElement {
    public static void main(String[] args) {

    }

    /**
     * 多数元素
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 多数元素 位运算
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement2(int[] nums) {
        int ans = 0;
        for (int i = 31; i >= 0 ; i--) {
            int bitSum = 0;
            for (int num : nums) {
                bitSum += (num >> i) & 1;
            }
            int bitNum = bitSum > (nums.length / 2) ? 1 : 0;
            ans = ans * 2 + bitNum;
        }
        return ans;
    }

    /**
     * 多数元素 分治
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param nums 数组
     * @return 多数数组
     */
    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count ++;
            }
        }
        return count;
    }

    public int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (high - low) / 2 + low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, high);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    /**
     * 多数元素 Boyer-Moore投票算法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 多数数组
     */
    public int majorityElement4(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num ? 1 : -1);
        }
        return candidate;
    }
}
