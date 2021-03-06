package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * No.3 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/31 10:18
 */
public class L0003LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 无重复字符的最长子串
     * 时间复杂度 O(N)
     * 空间复杂度 O(Σ)
     *
     * @param s 字符串
     * @return 最长子串的长度
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int j = -1;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (j + 1 < n && !occ.contains(s.charAt(j + 1))) {
                occ.add(s.charAt(j + 1));
                j++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}
