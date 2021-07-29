import java.util.Deque;
import java.util.LinkedList;

/**
 * No.19 删除链表的倒数第 N 个结点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/29 11:18
 */
public class L0019RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    /**
     * 删除链表的倒数第 N 个结点 双指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param n 倒数第n个
     * @return 新链表头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(0, head);
        ListNode left = dumpy;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            if (right != null) {
                right = right.next;
            }
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dumpy.next;
    }

    /**
     * 删除链表的倒数第 N 个结点 栈
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param n 倒数第n个
     * @return 新链表头节点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dumpy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dumpy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dumpy.next;
    }
}
