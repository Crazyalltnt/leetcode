/**
 * No.2 两数相加
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/26 21:31
 */
public class L0002AddTwoNumbers {
    public static void main(String[] args) {

    }

    /**
     * 两数相加
     * 时间复杂度 O(max(M,N))
     * 空间复杂度 O(1)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        int num1, num2, sum;
        int carry = 0;
        while (l1 != null || l2 != null) {
            num1 = l1 != null ? l1.val : 0;
            num2 = l2 != null ? l2.val : 0;
            sum = num1 + num2 + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum / 10;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dumpy.next;
    }
}
