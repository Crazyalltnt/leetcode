/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/12 9:58
 */
public class JZ52GetIntersectionNode {
    public static void main(String[] args) {

    }

    /**
     * 两个链表的第一个公共节点
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pHead1 链表1
     * @param pHead2 链表2
     * @return 公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? pHead2 : cur1.next;
            cur2 = cur2 == null ? pHead1 : cur2.next;
        }
        return cur1;
    }
}
