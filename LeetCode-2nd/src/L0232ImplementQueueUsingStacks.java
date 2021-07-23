import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No.232 用栈实现队列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/23 21:53
 */
public class L0232ImplementQueueUsingStacks {
    public static void main(String[] args) {

    }
}

/**
 * 用栈实现队列 双栈
 *
 * @author Neil
 * @date 2021/7/23 22:06
 * @version v1.0
 */
class MyQueue {
    Deque<Integer> pushStack;
    Deque<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (popStack.size() == 0) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (popStack.size() == 0) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */