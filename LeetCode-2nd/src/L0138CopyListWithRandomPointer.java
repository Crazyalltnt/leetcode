import java.util.HashMap;
import java.util.Map;

/**
 * No.138 复制带随机指针的链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/24 15:28
 */
public class L0138CopyListWithRandomPointer {
    /**
     * Definition for a Node.
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    Map<Node, Node> visitedHash = new HashMap<>();
    /**
     * 复制带随机指针的链表 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!visitedHash.containsKey(head)) {
            Node node = new Node(head.val);
            visitedHash.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return visitedHash.get(head);
    }

    /**
     * 复制带随机指针的链表 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(head.val);
        visitedHash.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedHash.get(head);
    }

    public Node getCloneNode(Node node) {
        if (node != null) {
            if (!visitedHash.containsKey(node)) {
                visitedHash.put(node, new Node(node.val));
            }
            return visitedHash.get(node);
        }
        return null;
    }

    /**
     * 复制带随机指针的链表 空间迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param head 头节点
     * @return 新链表头节点
     */
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }

        Node curOld = head, curNew = head.next;
        Node newHead = head.next;
        while (curOld != null) {
            curOld.next = curOld.next.next;
            curNew.next = (curNew.next != null) ? curNew.next.next : null;
            curOld = curOld.next;
            curNew = curNew.next;
        }
        return newHead;
    }
}
