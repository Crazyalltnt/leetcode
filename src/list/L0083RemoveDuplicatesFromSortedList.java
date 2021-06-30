package list;

/**
 * No.83 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/30 23:30
 */
public class L0083RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    /**
     * 删除排序链表中的重复元素
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
             if (cur.val == cur.next.val) {
                 cur.next = cur.next.next;
             } else {
                 cur = cur.next;
             }
        }
        return head;
    }
}
