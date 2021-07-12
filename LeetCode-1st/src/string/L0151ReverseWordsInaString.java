package string;

import java.util.*;

/**
 * No.151 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string
 *
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 * 输入：s = " hello world "
 * 输出："world hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 *
 * 示例 3：
 * 输入：s = "a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 *
 * 示例 4：
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 *
 * 示例 5：
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * 进阶：
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/23 9:10
 */
public class L0151ReverseWordsInaString {
    public static void main(String[] args) {

    }

    /**
     * 翻转字符串里的单词 java 内置函数
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 反转后的字符串
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> splitList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(splitList);
        return String.join(" ", splitList);
    }

    /**
     * 翻转字符串里的单词 自行编写函数
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 反转后的字符串
     */
    public String reverseWords2(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseSingleWord(sb);
        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseSingleWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    /**
     * 翻转字符串里的单词 队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 反转后的字符串
     */
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && c == ' ') {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }
}
