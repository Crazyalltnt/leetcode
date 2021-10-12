/**
 * 剑指 Offer 23. 链表中环的入口节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/12 10:34
 */
public class JZ23EntryNodeOfLoop {
    public static void main(String[] args) {

    }

    /**
     * 链表中环的入口结点 快慢指针
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pHead 头结点
     * @return 环入口
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                ListNode ptr = pHead;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
