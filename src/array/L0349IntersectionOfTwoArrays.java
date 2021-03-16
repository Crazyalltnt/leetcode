package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * No.349 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/16 11:30
 */
public class L0349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    /**
     * 获取交集 使用集合Set
     * 时间复杂度 O(M+N)
     * 空间复杂度 O(M+N)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 公共数组
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] intersection = new int[set2.size()];
        int index = 0;
        for (Integer num : set2) {
            intersection[index++] = num;
        }
        return intersection;
    }

    /**
     * 获取交集 使用双指针
     * 时间复杂度 O(MlogM + NlogN)
     * 空间复杂度 O(logM + logN)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 公共数组
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];

        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || nums1[i] != intersection[index - 1]) {
                    intersection[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
