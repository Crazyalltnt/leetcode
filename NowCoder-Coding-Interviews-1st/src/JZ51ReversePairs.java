/**
 * 剑指 Offer 51. 数组中的逆序对
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/15 15:45
 */
public class JZ51ReversePairs {
    public static void main(String[] args) {

    }

    int[] nums, tmp;
    /**
     * 数组中的逆序对
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(N)
     *
     * @param array 数组
     * @return 逆序对数
     */
    public int InversePairs(int[] array) {
        this.nums = array;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    public int mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }

        int middle = (left + right) / 2;
        int res = mergeSort(left, middle) + mergeSort(middle + 1, right);
        int i = left, j = middle + 1;
        System.arraycopy(nums, left, tmp, left, right + 1 - left);
        for (int k = left; k <= right; k++) {
            if (i == middle + 1) {
                nums[k] = tmp[j++];
            } else if (j == right + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += middle - i + 1;
                res %= 1000000007;
            }
        }
        return res;
    }
}
