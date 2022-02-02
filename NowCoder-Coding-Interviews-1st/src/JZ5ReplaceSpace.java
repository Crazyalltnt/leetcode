/**
 * 剑指 Offer 05. 替换空格
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/2 17:00
 */
public class JZ5ReplaceSpace {
    public static void main(String[] args) {

    }

    /**
     * 替换空格
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 新字符串
     */
    public String  replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 替换空格
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 新字符串
     */
    public String  replaceSpace2(String s) {
        return s.replace(" ", "%20");
    }
}
