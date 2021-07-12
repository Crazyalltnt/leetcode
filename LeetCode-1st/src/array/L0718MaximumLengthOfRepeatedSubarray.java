package array;

import java.util.HashSet;
import java.util.Set;

/**
 * No.718 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * <p>
 * 提示：
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/26 9:44
 */
public class L0718MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {

    }

    /**
     * 最长重复子数组 动态规划
     * 时间复杂度 O(M * N)
     * 空间复杂度 O(M * N)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最长子数组
     */
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 最长重复子数组 动态规划优化
     * 时间复杂度 O(M * N)
     * 空间复杂度 O(N)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最长子数组
     */
    public int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            int p = 0, q = 0;
            for (int j = n - 1; j >= 0; j--) {
                p = q;
                q = dp[j];
                dp[j] = (nums1[i] == nums2[j]) ? p + 1 : 0;
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }

    /**
     * 最长重复子数组 滑动窗口
     * 时间复杂度 O((M + N) * min(M, N))
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最长子数组
     */
    public int findLength3(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            ret = Math.max(ret, maxLen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(nums1, nums2, 0, i, len);
            ret = Math.max(ret, maxLen);
        }

        return ret;
    }

    public int maxLength(int[] nums1, int[] nums2, int add1, int add2, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[add1 + i] == nums2[add2 + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    /**
     * 最长重复子数组 滑动窗口优化
     * 时间复杂度 O((M + N) * min(M, N))
     * 空间复杂度 O(1)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最长子数组
     */
    public int findLength4(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, res = 0;
        // 枚举对应关系
        for (int diff = -(m - 1); diff <= n - 1; ++diff) {
            // 遍历公共部分
            for (int i = Math.max(0, -diff), l = 0; i < Math.min(m, n - diff); ++i) {
                l = (nums1[i] == nums2[i + diff]) ? (l + 1) : 0;
                res = Math.max(res, l);
            }
        }
        return res;
    }

    int mod = 1000000009;
    int base = 113;

    /**
     * 最长重复子数组 二分查找 + 哈希
     * 时间复杂度 O((M+N)*log(min(M,N)))
     * 空间复杂度 O(N)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 最长子数组
     */
    public int findLength5(int[] nums1, int[] nums2) {
        int left = 1, right = Math.min(nums1.length, nums2.length) + 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(nums1, nums2, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public boolean check(int[] nums1, int[] nums2, int len) {
        long hash1 = 0;
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * base + nums1[i]) % mod;
        }
        Set<Long> bucket1 = new HashSet<>();
        bucket1.add(hash1);
        long mult = qPow(base, len - 1);
        for (int i = len; i < nums1.length; i++) {
            hash1 = ((hash1 - nums1[i - len] * mult % mod + mod) % mod * base + nums1[i]) % mod;
            bucket1.add(hash1);
        }

        long hash2 = 0;
        for (int i = 0; i < len; i++) {
            hash2 = (hash2 * base + nums2[i]) % mod;
        }
        if (bucket1.contains(hash2)) {
            return true;
        }
        for (int i = len; i < nums2.length; i++) {
            hash2 = ((hash2 - nums2[i - len] * mult % mod + mod) % mod * base + nums2[i]) % mod;
            if (bucket1.contains(hash2)) {
                return true;
            }
        }
        return false;
    }

    // 使用快速幂来计算 x^n % mod 的值
    public long qPow(long x, long n) {
        long ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ret;
    }
}
