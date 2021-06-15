package array;

import java.util.Arrays;

/**
 * No.88 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/15 15:18
 */
public class L0088MergeSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 合并两个有序数组 直接插入排序
     * 时间复杂度 O((M+M)log(M+N))
     * 空间复杂度 O(log(M+N))
     *
     * @param nums1 数组1
     * @param m 元素个数
     * @param nums2 数组2
     * @param n 元素个数
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
        }
        Arrays.sort(nums1);
    }

    /**
     * 合并两个有序数组 双指针
     * 时间复杂度 O(M+M)
     * 空间复杂度 O(M+N)
     *
     * @param nums1 数组1
     * @param m 元素个数
     * @param nums2 数组2
     * @param n 元素个数
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (i < m || j < n) {
            if (i == m) {
                cur = nums2[j++];
            } else if (j == n) {
                cur = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }
            sorted[i + j - 1] = cur;
        }
        System.arraycopy(sorted, 0, nums1, 0, m + n);
    }

    /**
     * 合并两个有序数组 逆向双指针
     * 时间复杂度 O(M+M)
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param m 元素个数
     * @param nums2 数组2
     * @param n 元素个数
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int tail = m + n - 1;
        int cur;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                cur = nums2[j--];
            } else if (j == -1) {
                cur = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                cur = nums1[i--];
            } else {
                cur = nums2[j--];
            }
            nums1[tail--] = cur;
        }
    }
}
