package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * No.155 最小栈
 * https://leetcode-cn.com/problems/min-stack
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/27 9:47
 */
public class L0155MinStack {
    public static void main(String[] args) {
        // Your MinStack object will be instantiated and called as such:
        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}

class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStack2 {
    int min;
    Deque<Integer> stack;

    public MinStack2() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //当前值更小
        if(x <= min){
            //将之前的最小值保存
            stack.push(min);
            //更新最小值
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack3 {
    long min;
    Deque<Long> stack;

    public MinStack3(){
        stack=new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x - min);
        } else {
            stack.push(x - min);
            if (x < min){
                // 更新最小值
                min = x;
            }

        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        long pop = stack.pop();

        //弹出的是负值，要更新 min
        if (pop < 0) {
            min = min - pop;
        }

    }

    public int top() {
        long top = stack.peek();
        //负数的话，出栈的值保存在 min 中
        if (top < 0) {
            return (int) (min);
            //出栈元素加上最小值即可
        } else {
            return (int) (top + min);
        }
    }

    public int getMin() {
        return (int) min;
    }
}
