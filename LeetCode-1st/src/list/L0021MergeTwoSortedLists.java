package list;

/**
 * No.21 合并两个有序链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/6 9:52
 */
public class L0021MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode first = l1;
        ListNode second = l2;
        // int[] a1 = {1,2,4};
        // int[] a2 = {1,3,4};
        // int[] a1 = {};
        // int[] a2 = {};
        int[] a1 = {};
        int[] a2 = {0};

        for (int j : a1) {
            first.next = new ListNode(j);
            first = first.next;
        }

        for (int j : a2) {
            second.next = new ListNode(j);
            second = second.next;
        }

        first = l1.next;
        second = l2.next;
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
        System.out.println();
        while (second != null) {
            System.out.print(second.val + " ");
            second = second.next;
        }
        System.out.println();

        ListNode third = mergeTwoLists(l1.next, l2.next);
        while (third != null) {
            System.out.print(third.val + " ");
            third = third.next;
        }
    }

    /**
     * 合并有序链表 迭代法
     * 时间复杂度 O(M+N)
     * 空间复杂度 o(1)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
     * 合并有序链表 递归法
     * 时间复杂度 O(M+N)
     * 空间复杂度 O(M+N)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
