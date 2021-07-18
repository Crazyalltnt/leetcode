/**
 * No.21 合并两个有序链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/18 22:04
 */
public class L0021MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    /**
     * 合并两个有序链表 迭递归法
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(M + N)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 合并两个有序链表 迭代法
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return dumpy.next;
    }
}
