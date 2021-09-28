import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.394 字符串解码
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/27 16:36
 */
public class L0394DecodeString {
    public static void main(String[] args) {

    }

    int curIndex = 0;
    /**
     * 字符串解码 栈 法一
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 编码后的字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        while (curIndex < s.length()) {
            char cur = s.charAt(curIndex);
            if (Character.isDigit(cur)) {
                String digit = getDigits(s);
                stack.addLast(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(cur));
                curIndex++;
            } else {
                curIndex++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.pollLast());
                }
                Collections.reverse(sub);
                stack.pollLast();
                int repeatTimes = Integer.parseInt(stack.pollLast());
                StringBuilder tmp = new StringBuilder();
                String subString = getString(sub);
                while (repeatTimes-- > 0) {
                    tmp.append(subString);
                }
                stack.addLast(tmp.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuilder digitString = new StringBuilder();
        while (Character.isDigit(s.charAt(curIndex))) {
            digitString.append(s.charAt(curIndex++));
        }
        return digitString.toString();
    }

    public String getString(LinkedList<String> list) {
        StringBuilder string = new StringBuilder();
        for (String s : list) {
            string.append(s);
        }
        return string.toString();
    }

    /**
     * 字符串解码 栈 法二
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 编码后的字符串
     * @return 解码后的字符串
     */
    public String decodeString2(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString();
                stack.pop();

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int repeatTimes = Integer.parseInt(sb.toString());
                while (repeatTimes-- > 0) {
                    for (char c : sub.toCharArray()) {
                        stack.push(c);
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    int pointer;
    String src;
    /**
     * 字符串解码 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 编码后的字符串
     * @return 解码后的字符串
     */
    public String decodeString3(String s) {
        src = s;
        pointer = 0;
        return getString();
    }

    public String getString() {
        if (pointer == src.length() || src.charAt(pointer) == ']') {
            return "";
        }

        char cur = src.charAt(pointer);
        int repeatTimes = 1;
        StringBuilder ret = new StringBuilder();
        if (Character.isDigit(cur)) {
            repeatTimes = getDigits();
            pointer++;
            String str = getString();
            pointer++;
            while (repeatTimes-- > 0) {
                ret.append(str);
            }
        } else if (Character.isLetter(cur)) {
            ret = new StringBuilder(String.valueOf(cur));
            pointer++;
        }

        return ret + getString();
    }

    public int getDigits() {
        int digits = 0;
        while (Character.isDigit(src.charAt(pointer))) {
            digits = digits * 10 + src.charAt(pointer++) - '0';
        }
        return digits;
    }
}
