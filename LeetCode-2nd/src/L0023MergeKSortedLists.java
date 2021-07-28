import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * No.23 合并K个升序链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/28 10:43
 */
public class L0023MergeKSortedLists {
    public static void main(String[] args) {

    }

    /**
     * 合并K个升序链表 顺序合并
     * 时间复杂度 O(KN^2)
     * 空间复杂度 O(1)
     *
     * @param lists 链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode list : lists) {
            head = mergeTwoLists(head, list);
        }
        return head;
    }

    /**
     * 合并K个升序链表 分治合并
     * 时间复杂度 O(KN*logK)
     * 空间复杂度 O(logK)
     *
     * @param lists 链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int left = 0, right = lists.length - 1;
        return merge(lists, left, right);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dumpy.next;
    }

    /**
     * 合并K个升序链表 使用优先队列合并
     * 时间复杂度 O(KN*logK)
     * 空间复杂度 O(K)
     *
     * @param lists 链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dumpy = new ListNode();
        ListNode cur = dumpy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dumpy.next;
    }
}
