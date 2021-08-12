import sun.awt.geom.Curve;

/**
 * No.83 删除排序链表中的重复元素
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/12 22:23
 */
public class L0083RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    /**
     * 删除排序链表中的重复元素
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头结点
     * @return 新链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
