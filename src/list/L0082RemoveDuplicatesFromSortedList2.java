package list;

/**
 * No.82 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/1 16:31
 */
public class L0082RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {

    }

    /**
     * 删除排序链表中的重复元素 II
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dumpy = new ListNode(0, head);
        ListNode prev = dumpy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
                prev.next = cur;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dumpy.next;
    }
}
