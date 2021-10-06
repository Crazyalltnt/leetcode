/**
 * No.61 旋转链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/6 16:51
 */
public class L0061RotateList {
    public static void main(String[] args) {

    }

    /**
     * 旋转链表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @param k 位置
     * @return 新链表
     */
    public ListNode rotateRight(ListNode head, int k) {
       if (k == 0 || head == null || head.next == null) {
           return head;
       }

       int len = 1;
       ListNode ptr = head;
       while (ptr.next != null) {
           ptr = ptr.next;
           len++;
       }
       int add = len - k % len;
       if (add == len) {
           return head;
       }
       ptr.next = head;
       while (add-- > 0) {
           ptr = ptr.next;
       }
       ListNode ret = ptr.next;
       ptr.next = null;
       return ret;
    }
}
