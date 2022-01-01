/**
 * 剑指 Offer 19. 正则表达式匹配
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/1 15:23
 */
public class JZ19IsMatch {
    public static void main(String[] args) {

    }

    /**
     * 正则表达式匹配 动态规划
     * 时间复杂度 O(MN)
     * 空间复杂度 O(MN)
     *
     * @param str 字符串
     * @param pattern 模式串
     * @return 是否匹配
     */
    public boolean match(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();
        boolean[][] ans = new boolean[m + 1][n + 1];
        ans[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    ans[i][j] = ans[i][j - 2];
                    if (matches(str, pattern, i , j - 1)) {
                        ans[i][j] = ans[i][j] || ans[i - 1][j];
                    }
                } else {
                    if (matches(str, pattern, i, j)) {
                        ans[i][j] = ans[i - 1][j - 1];
                    }
                }
            }
        }
        return ans[m][n];
    }

    public boolean matches(String str, String pattern, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (pattern.charAt(j - 1) == '.') {
            return true;
        }
        return str.charAt(i - 1) == pattern.charAt(j - 1);
    }
}
