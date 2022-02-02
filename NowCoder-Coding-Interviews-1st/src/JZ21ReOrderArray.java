/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/2 17:33
 */
public class JZ21ReOrderArray {
    public static void main(String[] args) {

    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @return 新数组
     */
    public int[] reOrderArray (int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return array;
    }

}
