/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/13 16:26
 */
public class JZ22GetKthFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 链表中倒数第k个节点
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pHead 头结点
     * @param k 倒数k
     * @return 倒数第 k 个节点
     */
    public ListNode getKthFromEnd(ListNode pHead, int k) {
        ListNode first = pHead;
        while (k-- > 0) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }

        ListNode second = pHead;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
