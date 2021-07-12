package string;

/**
 * No.541 反转字符串2
 * https://leetcode-cn.com/problems/reverse-string-ii
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/27 15:25
 */
public class L0541ReverseString {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    /**
     * 反转字符串2 暴力
     *
     * @param s 字符串
     * @param k 间隔
     * @return 新字符串
     */
    public static String reverseStr(String s, int k) {
        char[] sArray = s.toCharArray();

        for (int start = 0; start < sArray.length; start += 2 * k) {
            int i = start;
            int j = Math.min(i + k - 1, sArray.length - 1);
            while (i < j) {
                char temp = sArray[i];
                sArray[i++] = sArray[j];
                sArray[j--] = temp;
            }
        }
        return new String(sArray);
    }
}
