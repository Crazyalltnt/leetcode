/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/5 14:55
 */
public class JZ18deleteNode {
    public static void main(String[] args) {

    }

    /**
     * 删除链表的节点
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param head 头结点
     * @param val 值
     * @return 新链表
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
