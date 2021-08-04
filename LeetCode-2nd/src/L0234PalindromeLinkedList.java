import java.util.ArrayList;
import java.util.List;

/**
 * No.234 回文链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/8/4 23:34
 */
public class L0234PalindromeLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 回文链表 快慢指针翻转 不考虑复原
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头结点
     * @return 是否回文链表
     */
    public boolean isPalindrome(ListNode head) {
        ListNode dumpy = new ListNode(0, head);
        ListNode slow = dumpy, fast = dumpy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextHalf = reverse(slow.next);
        while (nextHalf != null) {
            if (nextHalf.val != head.val) {
                return false;
            }
            head = head.next;
            nextHalf = nextHalf.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 回文链表 线性表
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头结点
     * @return 是否回文链表
     */
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private ListNode frontPointer;
    /**
     * 回文链表 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 是否回文链表
     */
    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
