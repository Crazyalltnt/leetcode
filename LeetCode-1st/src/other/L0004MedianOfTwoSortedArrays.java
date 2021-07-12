package other;

/**
 * No.4 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/26 10:36
 */
public class L0004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        // int[] nums2 = {1, 2};
        // int[] nums1 = {3, 4};

        System.out.println(findMedianSortedArrays3(nums1, nums2));
    }

    /**
     * 寻找两个正序数组的中位数 合并
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(M + N)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        int i = 0, j = 0, cur = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[cur++] = nums1[i++];
            } else {
                nums[cur++] = nums2[j++];
            }
        }

        while (i < m) {
            nums[cur++] = nums1[i++];
        }
        while (j < n) {
            nums[cur++] = nums2[j++];
        }

        int len = nums.length;
        if (len % 2 == 0) {
            return ((double)nums[len / 2 - 1] + nums[len / 2]) / 2;
        } else {
            return (double)nums[len / 2];
        }
    }

    /**
     * 寻找两个正序数组的中位数 双指针
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        int index1 = 0, index2 = 0;

        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }

        if ((len & 1) == 0) {
            return (left +  right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * 寻找两个正序数组的中位数 二分
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;

        if (len % 2 == 1) {
            return (double)findKthElement(nums1, nums2, len / 2 + 1);
        } else {
            return (findKthElement(nums1, nums2, len / 2) + findKthElement(nums1, nums2, len / 2 + 1)) / 2.0;
        }
    }

    /**
     * 寻找第k小的元素
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k 第k小
     * @return 第k小元素
     */
    public static int findKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2 = 0;


        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }

            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int mid1 = nums1[newIndex1];
            int mid2 = nums2[newIndex2];

            if (mid1 <= mid2) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
