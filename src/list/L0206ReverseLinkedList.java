package list;

/**
 * No.206 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/9 21:16
 */
public class L0206ReverseLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 反转链表 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 新头节点
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
        }
        return prev;
    }
}
