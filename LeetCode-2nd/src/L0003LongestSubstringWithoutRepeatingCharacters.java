import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * No.3 无重复字符的最长子串
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/15 10:40
 */
public class L0003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abba";
        System.out.print(lengthOfLongestSubstring2(s));
    }

    /**
     * 无重复字符的最长子串 滑动窗口 哈希集合
     * 时间复杂度 O(N)
     * 空间复杂度 O(|Σ|)
     *
     * @param s 字符串
     * @return 最长子串的长度
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int maxLen = 0;
        int right = -1;
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                charSet.remove(s.charAt(left - 1));
            }
            while (right + 1 < s.length() && !charSet.contains(s.charAt(right + 1))) {
                charSet.add(s.charAt(right + 1));
                right++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * 无重复字符的最长子串 滑动窗口 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(|Σ|)
     *
     * @param s 字符串
     * @return 最长子串的长度
     */
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (charMap.containsKey(ch)) {
                i = Math.max(charMap.get(ch) + 1, i);
            }
            charMap.put(ch, j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}
