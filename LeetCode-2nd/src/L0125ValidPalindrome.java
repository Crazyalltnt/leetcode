/**
 * No.125 验证回文串
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/8 19:45
 */
public class L0125ValidPalindrome {
    public static void main(String[] args) {

    }

    /**
     * 验证回文串
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 是否回文
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        s =s.toLowerCase();
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
