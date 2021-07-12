package string;

/**
 * No.125 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/29 20:04
 */
public class L0125ValidPalindrome {
    public static void main(String[] args) {
        // String s = "A man, a plan, a canal: Panama";
        // String s = ".,";
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    /**
     * 判断回文
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 是否回文
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
