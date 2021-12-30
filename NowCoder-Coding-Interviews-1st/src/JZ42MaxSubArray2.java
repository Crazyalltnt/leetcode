import java.util.Arrays;

/**
 * 剑指 Offer 42. 连续子数组的最大和 2
 *
 * @author Neil
 * @version v1.0
 * @date 2021/12/30 19:59
 */
public class JZ42MaxSubArray2 {
    public static void main(String[] args) {

    }

    /**
     * 连续子数组的最大和 2
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @return 最大和子数组
     */
    public int[] FindGreatestSumOfSubArray(int[] array) {
        int left = 0, right = 1;
        int snapLeft = 0, snapRight = 1;
        int maxSum = array[0], curSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i] + curSum) {
                curSum = array[i];
                left = i;
                right = i + 1;
            } else {
                curSum += array[i];
                right++;
            }
            if (curSum >= maxSum) {
                maxSum = curSum;
                snapLeft = left;
                snapRight = right;
            }
        }
        return Arrays.copyOfRange(array, snapLeft, snapRight);
    }
}
