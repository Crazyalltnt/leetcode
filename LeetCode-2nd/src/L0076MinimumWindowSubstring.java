import java.util.HashMap;
import java.util.Map;

/**
 * No.76 最小覆盖子串
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/9 19:00
 */
public class L0076MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    Map<Character, Integer> original = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    /**
     * 最小覆盖子串
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 最小子串
     */
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            original.put(t.charAt(i), original.getOrDefault(t.charAt(i), 0) + 1);
        }

        int sLen = s.length();
        int len = Integer.MAX_VALUE;
        int ansLeft = -1, ansRight = -1;
        int left = 0, right = 0;
        while (right < sLen) {
            right++;
            if (right < sLen && original.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansLeft = left;
                    ansRight = left + len;
                }
                if (original.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : original.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最小覆盖子串 滑动窗口 优化
     * 时间复杂度 O(1)
     * 空间复杂度 O(N)
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 最小子串
     */
    public String minWindow2(String s, String t) {
        int m = s.length(), n = t.length();
        char[] hash = new char[128];
        for (int i = 0; i < n; i++) {
            hash[t.charAt(i)]--;
        }

        int left = -1, right = -1;
        int count = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < m; i++) {
            hash[s.charAt(i)]++;
            if (hash[s.charAt(i)] <= 0) {
                count++;
            }
            while (count == n && hash[s.charAt(j)] > 0) {
                hash[s.charAt(j++)]--;
            }
            if (count == n && i - j + 1 < len) {
                len = i - j + 1;
                left = j;
                right = i + 1;
            }
        }
        return left == -1 ? "" : s.substring(left, right);
    }
}
