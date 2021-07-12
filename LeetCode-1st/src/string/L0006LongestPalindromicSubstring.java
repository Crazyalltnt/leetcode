package string;

/**
 * No.6 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/1 9:43
 */
public class L0006LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }

    /**
     * 最长回文子串 动态规划
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N^2)
     *
     * @param s 字符串
     * @return 回文子串
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int k = 0; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                } else {
                    boolean isEqual = s.charAt(i) == s.charAt(j);
                    if (k == 1) {
                        dp[i][j] = isEqual;
                    } else {
                        dp[i][j] = (isEqual && dp[i + 1][j - 1]);
                    }
                }

                if (dp[i][j] && k + 1 > res.length()) {
                    res = s.substring(i, i + k + 1);
                }
            }
        }
        return res;
    }

    /**
     * 最长回文子串 中心扩展
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 回文子串
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展子串
     *
     * @param s 字符串
     * @param left 左指针
     * @param right 右指针
     * @return 子串长度
     */
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
