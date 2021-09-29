import java.util.Deque;
import java.util.LinkedList;

/**
 * No.224 基本计算器
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/29 15:10
 */
public class L0224BasicCalculator {
    public static void main(String[] args) {

    }

    int index = 0;
    /**
     * 基本计算器 递归
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param s 字符串表达式
     * @return 计算结果
     */
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        int operation = '+';
        int num = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                num = calculate(s);
            }
            if ((!Character.isDigit(c) && c != ' ') || index == s.length()) {
                int tmp;
                switch (operation) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                num = 0;
                operation = c;
            }
            if (c == ')') {
                break;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    /**
     * 基本计算器
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串表达式
     * @return 计算值
     */
    public int calculate2(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);;
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+') {
                sign = ops.peek();
                i++;
            } else if (c == '-') {
                sign = -ops.peek();
                i++;
            } else if (c == '(') {
                ops.push(sign);
                i++;
            } else if (c == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + c - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
