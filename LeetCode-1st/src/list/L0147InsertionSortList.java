package list;

/**
 * No.147 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list
 *
 * 对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/1 12:56
 */
public class L0147InsertionSortList {
    public static void main(String[] args) {

    }

    /**
     * 对链表进行插入排序
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumpy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode sortCur = dumpy;
            while (sortCur.next != null && sortCur.next.val <= cur.val) {
                sortCur = sortCur.next;
            }
            cur.next = sortCur.next;
            sortCur.next = cur;
            cur = next;
        }
        return dumpy.next;
    }

    /**
     * 对链表进行插入排序 优化
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumpy = new ListNode(0, head);
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dumpy;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dumpy.next;
    }
}
