package dp;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.120 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点在这里指的是下标与上一层结点下标 相同或者等于上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/12 14:17
 */
public class L0120Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[][] array = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        for (Integer[] integers : array) {
            triangle.add(Arrays.asList(integers));
        }
        System.out.println(minimumTotal2(triangle));
    }

    /**
     * 三角形最小路径和 动态规划法
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N^2)
     *
     * @param triangle 三角数组
     * @return 三角形最小路径和
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int minTotal = dp[n - 1][0];
        for (int i = 1; i < dp[n - 1].length; i++) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }

    /**
     * 三角形最小路径和 动态规划法 空间优化
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param triangle 三角数组
     * @return 三角形最小路径和
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}
