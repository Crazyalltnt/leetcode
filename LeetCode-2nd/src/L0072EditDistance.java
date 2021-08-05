/**
 * No.72 编辑距离
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/5 11:43
 */
public class L0072EditDistance {
    public static void main(String[] args) {

    }

    /**
     * 编辑距离
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 最少操作数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        if (n * m == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int up = dp[i][j - 1] + 1;
                int leftUp = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftUp += 1;
                }
                dp[i][j] = Math.min(left, Math.min(up, leftUp));
            }
        }
        return dp[m][n];
    }
}
