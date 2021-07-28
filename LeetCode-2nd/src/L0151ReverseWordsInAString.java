import java.util.*;

/**
 * No.151 翻转字符串里的单词
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/28 20:54
 */
public class L0151ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "     a    good     example     ";
        String[] a = s.split(" +");
        System.out.println(Arrays.toString(a));
    }

    /**
     * 翻转字符串里的单词 java API
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转字符串
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" +");
        StringBuilder ans = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            ans.append(strings[i]);
            ans.append(" ");
        }
        ans.append(strings[0]);
        return ans.toString();
    }

    /**
     * 翻转字符串里的单词 java API 2
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转字符串
     */
    public String reverseWords2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split(" +")) ;
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 翻转字符串里的单词 自定义函数
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转字符串
     */
    public String reverseWords3(String s) {
        StringBuilder sb = trimString(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseSingleWord(sb);
        return sb.toString();
    }

    public StringBuilder trimString(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(ch);
            }
            left++;
        }
        System.out.println(sb);
        return sb;
    }

    public void reverseString(StringBuilder sb, int begin, int end) {
        while (begin < end) {
            char ch = sb.charAt(begin);
            sb.setCharAt(begin++, sb.charAt(end));
            sb.setCharAt(end--, ch);
        }
    }

    public void reverseSingleWord(StringBuilder sb) {
        int n = sb.length();
        int begin = 0, end = 0;
        while (begin < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, begin, end - 1);
            begin = end + 1;
            end++;
        }
    }

    /**
     * 翻转字符串里的单词 双端队列
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转字符串
     */
    public String reverseWords4(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        Deque<String> stringDeque = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            if (word.length() != 0 && ch == ' ') {
                stringDeque.offerFirst(word.toString());
                word.setLength(0);
            } else if (ch != ' ') {
                word.append(ch);
            }
            left++;
        }
        stringDeque.offerFirst(word.toString());
        return String.join(" ", stringDeque);
    }
}
