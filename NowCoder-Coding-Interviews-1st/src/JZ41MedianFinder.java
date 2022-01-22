import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/22 19:25
 */
public class JZ41MedianFinder {
    public static void main(String[] args) {

    }

    Queue<Integer> a, b;

    public JZ41MedianFinder() {
        a = new PriorityQueue<>();
        b = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void Insert(Integer num) {
        if (a.size() != b.size()) {
            a.add(num);
            b.add(a.poll());
        } else {
            b.add(num);
            a.add(b.poll());
        }
    }

    public Double GetMedian() {
        return a.size() != b.size() ? Double.valueOf(a.peek()) : (a.peek() + b.peek()) / 2.0;
    }
}
