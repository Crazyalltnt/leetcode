/**
 * 剑指 Offer 24. 反转链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/11 16:32
 */
public class JZ24ReverseList {
    public static void main(String[] args) {

    }

    /**
     * 反转链表 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头结点
     * @return 新链表
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 反转链表 遍历 非递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 新链表
     */
    public ListNode ReverseList2(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
