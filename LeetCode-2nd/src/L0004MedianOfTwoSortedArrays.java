/**
 * No.4 寻找两个正序数组的中位数
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/11 21:34
 */
public class L0004MedianOfTwoSortedArrays {
    public static void main(String[] args) {

    }

    /**
     * 寻找两个正序数组的中位数 合并
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, cur = 0;
        int[] nums = new int[m + n];
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
        if ((m + n) % 2 == 0) {
            return ((double)nums[(m + n) / 2] + nums[(m + n) / 2 - 1]) / 2;
        } else {
            return nums[(m + n) / 2];
        }
    }

    /**
     * 寻找两个正序数组的中位数 双指针
     * 时间复杂度 O(M+N)
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int index1 = 0, index2 = 0, cur = 0;
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }
        if ((len & 1) == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }
    }

    /**
     * 寻找两个正序数组的中位数 双指针
     * 时间复杂度 O(log(M+N))
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        if ((len & 1) == 0) {
            return (findKthElement(nums1, nums2, len / 2) + findKthElement(nums1, nums2, len / 2 + 1)) / 2.0;
        } else {
            return findKthElement(nums1, nums2, len / 2 + 1);
        }
    }

    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
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
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
