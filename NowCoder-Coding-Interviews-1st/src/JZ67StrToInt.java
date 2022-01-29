/**
 * 剑指 Offer 67. 把字符串转换成整数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/29 14:55
 */
public class JZ67StrToInt {
    public static void main(String[] args) {

    }

    /**
     * 把字符串转换成整数
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 数字
     */
    public int StrToInt (String s) {
        char[] ch = s.trim().toCharArray();
        if (ch.length == 0) {
            return 0;
        }
        int res = 0;
        int sign = 1, index = 1;
        int pre = Integer.MAX_VALUE / 10;
        int suffix = Integer.MAX_VALUE - pre * 10;
        if (ch[0] == '-') {
            sign = -1;
        } else if (ch[0] != '+') {
            index = 0;
        }
        for (int i = index; i < ch.length; i++) {
            if (ch[i] < '0' || ch[i] > '9') {
                break;
            }
            if (res > pre || res == pre && (ch[i] - '0' > suffix)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (ch[i] - '0');
        }
        return sign * res;
    }

    /**
     * 把字符串转换成整数
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param s 字符串
     * @return 数字
     */
    public int StrToInt2 (String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int res = 0;
        int index = 0, sign = 1;
        int pre = Integer.MAX_VALUE / 10;
        int suffix = Integer.MAX_VALUE - pre * 10;
        while (s.charAt(index) == ' ') {
            if (++index == len) {
                return 0;
            }
        }
        if (s.charAt(index) == '-') {
            sign = -1;
        }
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }
        for (int i = index; i < len; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            if (res > pre || res == pre && (s.charAt(i) - '0' > suffix)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }
}
