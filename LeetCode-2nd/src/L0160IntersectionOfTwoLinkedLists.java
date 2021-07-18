import java.util.HashSet;
import java.util.Set;

/**
 * No.160 相交链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/18 22:36
 */
public class L0160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    /**
     * 相交链表 迭代
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(1)
     *
     * @param headA 链表a
     * @param headB 链表b
     * @return 新链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

    /**
     * 相交链表 哈希表
     * 时间复杂度 O(M + N)
     * 空间复杂度 O(M)
     *
     * @param headA 链表a
     * @param headB 链表b
     * @return 新链表
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            visited.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
