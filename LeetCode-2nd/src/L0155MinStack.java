import java.util.Deque;
import java.util.LinkedList;

/**
 * No.155 最小栈
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/5 12:26
 */
public class L0155MinStack {
    public static void main(String[] args) {

    }
}

/**
 * 最小栈
 *
 * @author Neil
 * @date 2021/8/5 12:27
 * @version v1.0
 */
class MinStack {
    private Deque<Integer> stack;
    private int minValue;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= minValue) {
            stack.push(minValue);
            minValue = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == minValue) {
            minValue = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}

class MinStack2 {
    long min;
    Deque<Long> stack;

    public MinStack2(){
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */