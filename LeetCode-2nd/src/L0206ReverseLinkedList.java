/**
 * No.206 反转链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/12 10:18
 */
public class L0206ReverseLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 反转链表 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 反转链表 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}