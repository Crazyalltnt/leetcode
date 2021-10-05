import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No.225 用队列实现栈
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/5 21:55
 */
public class L0225ImplementStackUsingQueues {
    public static void main(String[] args) {

    }
}

// class MyStack {
//     Queue<Integer> queue1;
//     Queue<Integer> queue2;
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
//         Queue<Integer> tmpQueue = queue1;
//         queue1 = queue2;
//         queue2 = tmpQueue;
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


class MyStack {
    Deque<Integer> deque;
    public MyStack() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        int len = deque.size();
        deque.offerLast(x);
        for (int i = 0; i < len; i++) {
            deque.offerLast(deque.pollFirst());
        }
    }

    public int pop() {
        return deque.pollFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}