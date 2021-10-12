/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/12 9:35
 */
public class JZ25MergeTwoLists {
    public static void main(String[] args) {

    }

    /**
     * 合并两个排序的链表
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
