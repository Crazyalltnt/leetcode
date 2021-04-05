package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * No.20 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/5 9:49
 */
public class L0020ValidParentheses {
    public static void main(String[] args) {
        String s0 = "()";
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([)]";
        String s4 = "{[]}";
        String s5 = "";

        System.out.println(isValid(s0));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '[' && s.charAt(i) == ']') || (
                    stack.peek() == '{' && s.charAt(i) == '}')) {
                    stack.pop();
                } else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
