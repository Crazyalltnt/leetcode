package list;

/**
 * No.25 K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 *
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/11 22:00
 */
public class L0025ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    /**
     * K 个一组翻转链表
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param head 头节点
     * @param k 分组大小
     * @return 翻转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode pre = dumpy;

        while (head != null) {
            ListNode tail = pre;

            // 查看剩余部分长度是否大于等于 k
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

            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dumpy.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
