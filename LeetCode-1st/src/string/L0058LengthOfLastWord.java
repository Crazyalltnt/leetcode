package string;

/**
 * No.58 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word
 *
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 *
 * @author Neil
 * @version v1.0
 * @date 2021/3/30 9:55
 */
public class L0058LengthOfLastWord {
    public static void main(String[] args) {
        // String s = "Hello World";
        String s = " ";
        // String s = "Hello World..";
        System.out.println(lengthOfLastWord(s));
    }

    /**
     * 最后一个单词长度
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param s 字符串
     * @return 长度
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int i = s.length() - 1;

        while (i >= 0) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
                i--;
            } else if (count == 0){
                i--;
            } else {
                break;
            }
        }
        return count;
    }
}
