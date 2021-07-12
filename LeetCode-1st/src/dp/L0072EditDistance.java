package dp;

/**
 * No.72 编辑距离
 * https://leetcode-cn.com/problems/edit-distance
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/3 9:56
 */
public class L0072EditDistance {
    public static void main(String[] args) {

    }

    /**
     * 编辑距离 动态规划
     * 时间复杂度 O(M)
     * 空间复杂度 O(N)
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 最少操作数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        if (m * n == 0) {
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
                int add = dp[i - 1][j] + 1;
                int remove = dp[i][j - 1] + 1;
                int replace = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace += 1;
                }
                dp[i][j] = Math.min(add, Math.min(remove, replace));
            }
        }
        return dp[m][n];
    }
}
