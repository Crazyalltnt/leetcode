package list;

import java.util.HashMap;
import java.util.Map;

/**
 * No.138 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 * 提示：
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/11 10:21
 */
public class CopyListWithRandomPointer {
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

        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        Node node = new Node(head.val, null, null);
        visitedHash.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
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
        Node newNode = new Node(oldNode.val, null, null);
        visitedHash.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedHash.get(head);
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (!visitedHash.containsKey(node)) {
                visitedHash.put(node, new Node(node.val, null, null));
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
            Node newNode = new Node(cur.val, null, null);
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

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
