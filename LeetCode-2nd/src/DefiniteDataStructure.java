/**
 * 定义题目内置的各种数据结构
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/12 10:21
 */
public class DefiniteDataStructure {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 *
 * @author Neil
 * @date 2021/7/12 10:25
 * @version v1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Definition for a binary tree node.
 *
 * @author Neil
 * @date 2021/7/20 15:50
 * @version v1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}