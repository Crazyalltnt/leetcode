package string;

/**
 * No.796 旋转字符串
 * https://leetcode-cn.com/problems/rotate-string
 *
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea'。如果在若干次旋转操作之后，A 能变成B，那么返回 True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/29 21:00
 */
public class L0796RotateString {
    public static void main(String[] args) {
        // String A = "abcde";
        String A = "gcmbf";
        // String B = "cdeab";
        // String B = "abced";
        String B = "fgcmb";
        System.out.println(rotateString(A, B));
    }

    /**
     * 旋转字符串
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param A 字符串
     * @param B 字符串
     * @return 旋转是否相等
     */
    public static boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            return true;
        }

        int len = A.length();
        for (int i = 0; i < len - 1; i++) {
            A = A.substring(1, len) + A.charAt(0);
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }
}
