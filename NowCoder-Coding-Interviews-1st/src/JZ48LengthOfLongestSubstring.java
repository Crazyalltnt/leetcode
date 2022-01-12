import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/12 20:15
 */
public class JZ48LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    /**
     * 最长不含重复字符的子字符串 动态规划+哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 子串
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), - 1);
            map.put(s.charAt(j), j);
            // dp[j-1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 最长不含重复字符的子字符串 动态规划+线性遍历
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 子串
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) {
                i--;
            }
            tmp = tmp < j -i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 最长不含重复字符的子字符串 双指针+哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 子串
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
