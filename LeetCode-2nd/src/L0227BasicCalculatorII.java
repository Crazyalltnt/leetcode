import java.util.Deque;
import java.util.LinkedList;

/**
 * No.227 基本计算器 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/18 20:54
 */
public class L0227BasicCalculatorII {
    public static void main(String[] args) {

    }

    /**
     * 基本计算器 II
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param s 字符串表达式
     * @return 计算结果
     */
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
