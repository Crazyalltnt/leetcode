package list;

/**
 * No.61 旋转链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/14 21:41
 */
public class L0061RotateList {
    public static void main(String[] args) {

    }

    /**
     * 旋转链表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param k 移动次数
     * @return 新的头节点
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int n = 1;
        ListNode counter = head;
        while (counter.next != null) {
            counter = counter.next;
            n++;
        }

        if (k % n == 0) {
            return head;
        }

        int tail = n - k % n;
        counter.next = head;
        while (tail-- > 0) {
            counter = counter.next;
        }

        ListNode newHead = counter.next;
        counter.next = null;
        return newHead;
    }
}
