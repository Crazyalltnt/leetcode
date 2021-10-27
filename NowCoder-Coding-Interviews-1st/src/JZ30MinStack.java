import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/27 15:46
 */
public class JZ30MinStack {
    public static void main(String[] args) {

    }
}

class Solution {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        if (node <= min) {
            stack.push(min);
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}