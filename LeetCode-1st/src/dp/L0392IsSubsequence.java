package dp;

/**
 * No.392 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/23 22:26
 */
public class L0392IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence2(s, t));
    }

    /**
     * 判断子序列 双指针
     * 时间复杂度 O(M+N)
     * 空间复杂度 O(1)
     *
     * @param s 子串
     * @param t 字符串
     * @return 是否子序列
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * 判断子序列 动态规划
     * 时间复杂度 O(M*26+N)
     * 空间复杂度 O(M*26)
     *
     * @param s 子串
     * @param t 字符串
     * @return 是否子序列
     */
    public static boolean isSubsequence2(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++) {
            if (dp[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
