/**
 * No.5 最长回文子串
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/24 10:16
 */
public class L0005LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    /**
     * 最长回文子串 动态规划
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N^2)
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int curLen = 2; curLen <= len; curLen++) {
            for (int i = 0; i < len; i++) {
                int j = i + curLen - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (curLen == 2 || curLen == 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && curLen > maxLen) {
                    maxLen = curLen;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 最长回文子串 动态规划
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - begin + 1) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
