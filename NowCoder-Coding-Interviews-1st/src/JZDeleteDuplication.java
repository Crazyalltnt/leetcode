/**
 * 剑指 Offer 删除链表中重复的结点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/14 10:05
 */
public class JZDeleteDuplication {
    public static void main(String[] args) {

    }

    /**
     * 删除链表中重复的结点
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pHead 头结点
     * @return 新链表
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode prev = dummy;
        while (true) {
            if (prev.next == null || prev.next.next == null) {
                break;
            } else if (prev.next.val != prev.next.next.val) {
                prev = prev.next;
            } else {
                ListNode tmp = prev.next;
                while (tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                prev.next = tmp.next;
            }
        }
        return dummy.next;
    }

    /**
     * 删除排序链表中的重复元素 II 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pHead 头结点
     * @return 新链表头结点
     */
    public ListNode deleteDuplication3(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val != pHead.next.val) {
            pHead.next = deleteDuplication3(pHead.next);
            return pHead;
        } else {
            ListNode next = pHead.next;
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication3(next);
        }
    }
}
