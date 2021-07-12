package list;

/**
 * No.92 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/21 10:21
 */
public class L0092ReverseLinkedListII {
    public static void main(String[] args) {

    }

    /**
     * 反转链表 II 直接反转方向
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param left 起始节点
     * @param right 结束节点
     * @return 反转后的链表头节点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        int cur = 1;
        ListNode curNode = head;
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode leftPreNode = dumpy;
        ListNode rightNextNode = null;
        while (cur < left) {
            leftPreNode = curNode;
            curNode = curNode.next;
            cur++;
        }

        ListNode pre = null;
        ListNode leftNode = curNode;
        ListNode next;
        while (cur < right) {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
            cur++;
        }

        rightNextNode = curNode.next;
        curNode.next = pre;
        leftPreNode.next = curNode;
        leftNode.next = rightNextNode;
        return dumpy.next;
    }

    /**
     * 反转链表 II 头插法
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @param left 起始节点
     * @param right 结束节点
     * @return 反转后的链表头节点
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

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
