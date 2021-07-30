import java.util.LinkedList;
import java.util.List;

/**
 * No.143 重排链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/30 21:59
 */
public class L0143ReorderList {
    public static void main(String[] args) {

    }

    /**
     * 重排链表 找中点+反转+合并
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }
        ListNode dumpy = new ListNode(0, head);
        ListNode slow = dumpy, fast = dumpy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        mergeLists(head, head2);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void mergeLists(ListNode l1, ListNode l2) {
        ListNode next1, next2;
        while (l2 != null) {
            next1 = l1.next;
            l1.next = l2;
            next2 = l2.next;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }

    /**
     * 重排链表 线性表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }

        List<ListNode> nodeList = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }
        int i = 0, j = nodeList.size() - 1;
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        nodeList.get(i).next = null;
    }
}
