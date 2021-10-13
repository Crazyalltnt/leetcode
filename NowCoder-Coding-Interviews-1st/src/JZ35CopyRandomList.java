import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/13 16:50
 */
public class JZ35CopyRandomList {
    public static void main(String[] args) {

    }

    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    /**
     * 复杂链表的复制 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pHead 头结点
     * @return 新链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        if (!map.containsKey(pHead)) {
            RandomListNode node = new RandomListNode(pHead.label);
            map.put(pHead, node);
            node.next = Clone(pHead.next);
            node.random = Clone(pHead.random);
        }
        return map.get(pHead);
    }

    /**
     * 复杂链表的复制 迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param pHead 头结点
     * @return 新链表
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode oldNode = pHead;
        RandomListNode newNode = new RandomListNode(pHead.label);
        map.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getClone(oldNode.next);
            newNode.random = getClone(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(pHead);
    }


    public RandomListNode getClone(RandomListNode node) {
        if (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new RandomListNode(node.label));
            }
            return map.get(node);
        }
        return null;
    }

    /**
     * 复杂链表的复制 空间迭代
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pHead 头结点
     * @return 新链表
     */
    public RandomListNode Clone3(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = pHead;
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        RandomListNode curOld = pHead, curNew = pHead.next;
        RandomListNode newHead = pHead.next;
        while (curOld != null) {
            curOld.next = curOld.next.next;
            curNew.next = curNew.next != null ? curNew.next.next : null;
            curOld = curOld.next;
            curNew = curNew.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
