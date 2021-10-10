import java.util.*;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/10 16:13
 */
public class JZ06ReversePrint {
    public static void main(String[] args) {

    }

    ArrayList<Integer> list = new ArrayList<>();
    /**
     * 从尾到头打印链表 递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param listNode 头结点
     * @return 返回值
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 从尾到头打印链表 遍历 非递归 反转
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param listNode 头结点
     * @return 返回值
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 从尾到头打印链表 遍历 非递归
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param listNode 头结点
     * @return 返回值
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    /**
     * 从尾到头打印链表  遍历 非递归 栈
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param listNode 头结点
     * @return 返回值
     */
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
