/**
 * No.24 两两交换链表中的节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/17 15:12
 */
public class L0024SwapNodesInPairs {
    public static void main(String[] args) {

    }

    /**
     * 两两交换链表中的节点 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头结点
     * @return 交换后的链表
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 两两交换链表中的节点 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 交换后的链表
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, first = head, second = head.next;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev =  first;
            first = first.next;
            second = first == null ? null : first.next;
        }
        return dummy.next;
    }

    /**
     * 两两交换链表中的节点 迭代2
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 交换后的链表
     */
    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }
}
