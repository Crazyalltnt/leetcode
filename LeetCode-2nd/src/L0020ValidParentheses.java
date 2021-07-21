import java.util.Deque;
import java.util.LinkedList;

/**
 * No.20 有效的括号
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/21 9:37
 */
public class L0020ValidParentheses {
    public static void main(String[] args) {

    }

    /**
     * 有效的括号
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串
     * @return 是否有效
     */
    public boolean isValid(String s) {
        int len = s.length();
        Deque<Character> stack = new LinkedList<>();
        int index = 0;
        while (index < len) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            index++;
        }
        return stack.isEmpty();
    }
}
