/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/12 20:33
 */
public class JZ11MinArray {
    public static void main(String[] args) {

    }

    /**
     * 旋转数组的最小数字
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param array 旋转数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
