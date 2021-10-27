import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/27 15:25
 */
public class JZ09CQueue {
    public static void main(String[] args) {

    }
}

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
