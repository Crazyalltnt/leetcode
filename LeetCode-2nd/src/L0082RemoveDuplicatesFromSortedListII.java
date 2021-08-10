/**
 * No.82 删除排序链表中的重复元素 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/10 19:18
 */
public class L0082RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {

    }

    /**
     * 删除排序链表中的重复元素 II 迭代 1
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 新链表头结点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dumpy = new ListNode(0, head);
        ListNode pre = dumpy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dumpy.next;
    }

    /**
     * 删除排序链表中的重复元素 II 迭代 2
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 新链表头结点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    /**
     * 删除排序链表中的重复元素 II 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 新链表头结点
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates3(head.next);
            return head;
        } else {
            ListNode next = head.next;
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            return deleteDuplicates3(next);
        }
    }
}
