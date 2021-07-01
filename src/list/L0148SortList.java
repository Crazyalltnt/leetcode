package list;

/**
 * No.148 排序链表
 * https://leetcode-cn.com/problems/sort-list
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 * 你可以在 O(nlog n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/1 9:42
 */
public class L0148SortList {
    public static void main(String[] args) {

    }

    /**
     * 排序链表 自顶向下归并排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dumpy = new ListNode();
        ListNode temp = dumpy, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dumpy.next;
    }

    /**
     * 排序链表 自顶向下归并排序 简化
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(logN)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return merge(sortList2(head), sortList2(head2));
    }

    /**
     * 排序链表 自顶向下归并排序
     * 时间复杂度 O(NlogN)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode sortList3(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dumpy = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode prev = dumpy, cur = dumpy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dumpy.next;
    }
}
