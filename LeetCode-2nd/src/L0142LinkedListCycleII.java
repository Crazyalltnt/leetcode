import java.util.HashSet;
import java.util.Set;

/**
 * No.142 环形链表 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/22 9:43
 */
public class L0142LinkedListCycleII {
    public static void main(String[] args) {

    }

    /**
     * 环形链表 II 哈希表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 入环的位置
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * 环形链表 II 快慢指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 入环的位置
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode pos = head;
                while (pos != slow) {
                    pos = pos.next;
                    slow = slow.next;
                }
                return pos;
            }
        }
        return null;
    }
}
