/**
 * 剑指 Offer 08. 二叉树的下一个结点
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/25 20:56
 */
public class JZ08GetNext {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的下一个结点
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param pNode 节点
     * @return 下一个节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            TreeLinkNode nextNode = pNode.right;
            while (nextNode.left != null) {
                nextNode = nextNode.left;
            }
            return nextNode;
        }
        while (pNode.next != null) {
            TreeLinkNode pRoot = pNode.next;
            if (pRoot.left == pNode) {
                return pRoot;
            }
            pNode = pNode.next;
        }
        return null;
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}