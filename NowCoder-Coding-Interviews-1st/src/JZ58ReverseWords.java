import java.util.*;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/10 20:05
 */
public class JZ58ReverseWords {
    public static void main(String[] args) {

    }

    /**
     * 翻转单词顺序
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> splitList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(splitList);
        return String.join(" ", splitList);
    }

    /**
     * 翻转单词顺序
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public String reverseWords2(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }

    /**
     * 翻转单词顺序
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public String reverseWords3(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j && s.charAt(i) == ' ') {
            i++;
        }
        while (i <= j && s.charAt(j) == ' ') {
            j--;
        }
        Deque<String> deque = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        while (i <= j) {
            char c = s.charAt(i);
            if (word.length() != 0 && c == ' ') {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            i++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}
