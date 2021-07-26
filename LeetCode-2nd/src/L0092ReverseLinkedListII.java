/**
 * No.92 反转链表 II
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/26 16:26
 */
public class L0092ReverseLinkedListII {
    public static void main(String[] args) {

    }

    /**
     * 反转链表 II 一次遍历 直接反转
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param left 起始节点
     * @param right 结束节点
     * @return 新链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode leftPreNode = dumpy;
        for (int i = 0; i < left - 1; i++) {
            leftPreNode = leftPreNode.next;
        }

        ListNode leftNode = leftPreNode.next;
        ListNode cur = leftNode;
        ListNode pre = null;
        ListNode next;
        for (int i = 0; i < right - left + 1; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode rightNextNode = cur;
        leftPreNode.next = pre;
        leftNode.next = rightNextNode;
        return dumpy.next;
    }

    /**
     * 反转链表 II 一次遍历 头插法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param left 起始节点
     * @param right 结束节点
     * @return 新链表
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode pre = dumpy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dumpy.next;
    }
}
