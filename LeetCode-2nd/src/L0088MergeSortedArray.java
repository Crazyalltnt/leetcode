/**
 * No.88 合并两个有序数组
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/21 9:21
 */
public class L0088MergeSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 合并两个有序数组
     * 时间复杂度 O(M+N)
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param m 数组1长度
     * @param nums2 数组2
     * @param n 数组2长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
