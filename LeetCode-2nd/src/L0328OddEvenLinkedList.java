import java.util.LinkedList;

/**
 * No.328 奇偶链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/25 20:31
 */
public class L0328OddEvenLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 奇偶链表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 新节点
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode curOdd = head, curEven = evenHead;
        while (curEven != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;
            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = evenHead;
        return head;
    }
}
