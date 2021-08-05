/**
 * No.148 排序链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/5 13:01
 */
public class L0148SortList {
    public static void main(String[] args) {

    }

    /**
     * 排序链表 自顶向下归并排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param head 头结点
     * @return 排序后的链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(head2));
    }

    /**
     * 排序链表 自底向上归并排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 排序后的链表
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dumpy = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dumpy, cur = dumpy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while (pre.next != null) {
                    pre =  pre.next;
                }
                cur = next;
            }
        }
        return dumpy.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dumpy = new ListNode();
        ListNode temp = dumpy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        return dumpy.next;
    }
}
