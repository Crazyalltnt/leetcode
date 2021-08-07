/**
 * No.1143 最长公共子序列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/7 20:54
 */
public class L1143LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    /**
     * 最长公共子序列 动态规划
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i- 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 最长公共子序列 动态规划 优化
     * 时间复杂度 O(MN)
     * 空间复杂度 O(N)
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i & 1][j] = dp[i & 1 ^ 1][j - 1] + 1;
                } else {
                    dp[i & 1][j] = Math.max(dp[i & 1 ^ 1][j], dp[i & 1][j - 1]);
                }
            }
        }
        return dp[m & 1][n];
    }
}
