/**
 * No.8 字符串转换整数 (atoi)
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/29 9:45
 */
public class L0008StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE % 10);
    }

    /**
     * 字符串转换整数 (atoi) 截取子串
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 整数
     */
    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        if (left == s.length() || !(s.charAt(left) == '+' || s.charAt(left) == '-' || Character.isDigit(s.charAt(left)))) {
            return 0;
        }
        if (s.charAt(left) == '+' || s.charAt(left) == '-') {
            if (left == s.length() - 1 || !Character.isDigit(s.charAt(left + 1))) {
                return 0;
            }
        }
        int right = left + 1;
        while (right < s.length() && Character.isDigit(s.charAt(right))) {
            right++;
        }

        long signBit;
        String subString;
        if (s.charAt(left) == '+') {
            signBit = 1;
            subString = s.substring(left + 1, right);
        } else if (s.charAt(left) == '-') {
            signBit = -1;
            subString = s.substring(left + 1, right);
        } else {
            signBit = 1;
            subString = s.substring(left, right);
        }

        long num = 0;
        for (int i = 0; i < subString.length(); i++) {
            num = subString.charAt(i) - '0' + num * 10;
            if (signBit * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (signBit * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int)(signBit * num);
    }

    /**
     * 字符串转换整数 (atoi) 按位累加
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 整数
     */
    public static int myAtoi2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        if (start == s.length()) {
            return 0;
        }
        int sign = 1;
        long num = 0;
        if (s.charAt(start) == '+') {
            start++;
        } else if (s.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            } else {
                break;
            }

            if (num * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(num * sign);
    }
}
