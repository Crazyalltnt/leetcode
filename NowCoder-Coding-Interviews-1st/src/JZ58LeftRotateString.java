/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/9 16:01
 */
public class JZ58LeftRotateString {
    public static void main(String[] args) {

    }

    /**
     * 左旋转字符串 字符串切片，前提 n < len
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param str 字符串
     * @param n 旋转量
     * @return 新字符串
     */
    public String LeftRotateString(String str,int n) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        n %= str.length();
        return str.substring(n) + str.substring(0, n);
    }

    /**
     * 左旋转字符串 列表遍历拼接
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param str 字符串
     * @param n 旋转量
     * @return 新字符串
     */
    public String LeftRotateString2(String str,int n) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }

        int len = str.length();
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + len; i++) {
            res.append(str.charAt(i % len));
        }
        return res.toString();
    }
}
