package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No.225 用队列实现栈
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/3 16:25
 */
public class L0225ImplementStackUsingQueues {
    public static void main(String[] args) {

    }
}

// /**
//  * 双端队列
//  */
// class MyStack {
//     Deque<Integer> stack;
//     public MyStack() {
//         stack = new LinkedList<>();
//     }
//
//     public void push(int x) {
//         stack.offerLast(x);
//     }
//
//     public int pop() {
//         return stack.pollLast();
//     }
//
//     public int top() {
//         return stack.peekLast();
//     }
//
//     public boolean empty() {
//         return stack.isEmpty();
//     }
// }

// /**
//  * 两个队列
//  */
// class MyStack {
//     Queue<Integer> queue1;
//     Queue<Integer> queue2;
//
//     public MyStack() {
//         queue1 = new LinkedList<>();
//         queue2 = new LinkedList<>();
//     }
//
//     public void push(int x) {
//         queue2.offer(x);
//         while (!queue1.isEmpty()) {
//             queue2.offer(queue1.poll());
//         }
//         Queue<Integer> tmp = queue1;
//         queue1 = queue2;
//         queue2 = tmp;
//     }
//
//     public int pop() {
//         return queue1.poll();
//     }
//
//     public int top() {
//         return queue1.peek();
//     }
//
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }

/**
 * 一个队列
 */
class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}