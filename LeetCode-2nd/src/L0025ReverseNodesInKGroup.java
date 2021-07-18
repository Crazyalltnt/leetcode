/**
 * No.25 K 个一组翻转链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/18 9:47
 */
public class L0025ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    /**
     * K 个一组翻转链表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param k 分组大小
     * @return 新链表头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode pre = dumpy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dumpy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dumpy.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[] {tail, head};
    }
}
