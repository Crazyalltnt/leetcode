package list;

import java.util.PriorityQueue;

/**
 * No.23 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/11 9:53
 */
public class L0023MergekSortedLists {
    public static void main(String[] args) {

    }

    /**
     * 合并 K 个升序列表 顺序合并
     * 时间复杂度 O(K^2N)
     * 空间复杂度 O(1)
     *
     * @param lists 链表数组
     * @return 合并链表头节点
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dumpy = null;
        for (ListNode list : lists) {
            dumpy = mergeTwoLists(dumpy, list);
        }
        return dumpy;
    }

    /**
     * 合并 K 个升序列表 分治合并
     * 时间复杂度 O(KNlogK)
     * 空间复杂度 O(1)
     *
     * @param lists 链表数组
     * @return 合并链表头节点
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 合并 K 个升序列表 优先队列
     * 时间复杂度 O(KNlogK)
     * 空间复杂度 O(K)
     *
     * @param lists 链表数组
     * @return 合并链表头节点
     */
    public static ListNode mergeKLists3(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }

    /**
     * 合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并链表头节点
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode cur = l;
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
        return l.next;
    }

    /**
     * 递归合并子列表链表
     *
     * @param lists 链表列表
     * @param l 列表起始
     * @param r 列表终止索引
     * @return 合并后的链表
     */
    public static ListNode merge(ListNode[] lists, int l ,int r) {
        if (l == r) {
            return lists[l];
        }

        if (l > r) {
            return null;
        }

        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    static PriorityQueue<Status> queue = new PriorityQueue<Status>();
    static class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override public int compareTo(Status o) {
            return this.val - o.val;
        }
    }
}
