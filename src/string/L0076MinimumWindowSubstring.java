package string;

import java.util.HashMap;
import java.util.Map;

/**
 * No.76 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/4 15:56
 */
public class L0076MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    Map<Character, Integer> original = new HashMap<>();
    Map<Character, Integer> windowCount = new HashMap<>();

    /**
     * 最小覆盖子串 滑动窗口
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 最小覆盖子串
     */
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            original.put(t.charAt(i), original.getOrDefault(t.charAt(i), 0) + 1);
        }

        int sLength = s.length();
        int len = Integer.MAX_VALUE;
        int ansLeft = -1, ansRight = -1;
        int left = 0, right = -1;
        while (right < sLength) {
            right++;
            if (right < sLength && original.containsKey(s.charAt(right))) {
                windowCount.put(s.charAt(right), windowCount.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansLeft = left;
                    ansRight = left + len;
                }
                if (original.containsKey(s.charAt(left))) {
                    windowCount.put(s.charAt(left), windowCount.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : original.entrySet()) {
            if (windowCount.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最小覆盖子串 滑动窗口 优化
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 最小覆盖子串
     */
    public String minWindow2(String s, String t) {
        char[] sChar = s.toCharArray(), tChar = t.toCharArray();
        int m = sChar.length, n = tChar.length;

        int[] hash = new int[128];
        for (char ch : tChar) {
            hash[ch]--;
        }

        int left = -1, right = -1;
        int count = 0, len = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < m; i++) {
            hash[sChar[i]]++;
            if (hash[sChar[i]] <= 0) {
                count++;
            }
            while (count == n && hash[sChar[j]] > 0) {
                hash[sChar[j++]]--;
            }
            if (count == n) {
                if (i - j + 1 < len) {
                    len = i - j + 1;
                    left = j;
                    right = i + 1;
                }
            }
        }
        return left == -1 ? "" : s.substring(left, right);
    }
}
