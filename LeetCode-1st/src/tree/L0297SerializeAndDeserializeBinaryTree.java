package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * No.297 二叉树的序列化与反序列化
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/3 19:12
 */
public class L0297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {

    }

    // /**
    //  * 序列化和反序列化 深度优先搜索 前序遍历
    //  * 时间复杂度 O(N)
    //  * 空间复杂度 O(N)
    //  */
    //
    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     return rserialize(root, "");
    // }
    //
    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     String[] dataArray = data.split(",");
    //     List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
    //     return rdeserialize(dataList);
    // }
    //
    // public String rserialize(TreeNode root, String str) {
    //     if (root == null) {
    //         str += "None,";
    //     } else {
    //         str += root.val + ",";
    //         str = rserialize(root.left, str);
    //         str = rserialize(root.right, str);
    //     }
    //     return str;
    // }
    //
    // public TreeNode rdeserialize(List<String> dataList) {
    //     if ("None".equals(dataList.get(0))) {
    //         dataList.remove(0);
    //         return null;
    //     }
    //
    //     TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
    //     dataList.remove(0);
    //     root.left = rdeserialize(dataList);
    //     root.right = rdeserialize((dataList));
    //     return root;
    // }

    /**
     * 序列化和反序列化 深度优先搜索 前序遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String left = "(" + serialize(root.left) + ")";
        String right = "(" + serialize(root.right) + ")";
        return left + root.val + right;
    }

    public TreeNode deserialize(String data) {
        int[] ptr = {0};
        return parse(data, ptr);
    }

    public TreeNode parse(String data, int[] ptr) {
        if (data.charAt(ptr[0]) == 'X') {
            ++ptr[0];
            return null;
        }
        TreeNode cur = new TreeNode(0);
        cur.left = parseSubtree(data, ptr);
        cur.val = parseInt(data, ptr);
        cur.right = parseSubtree(data, ptr);
        return cur;
    }

    public TreeNode parseSubtree(String data, int[] ptr) {
        ++ptr[0]; // 跳过左括号
        TreeNode subtree = parse(data, ptr);
        ++ptr[0]; // 跳过右括号
        return subtree;
    }

    public int parseInt(String data, int[] ptr) {
        int x = 0, sgn = 1;
        if (!Character.isDigit(data.charAt(ptr[0]))) {
            sgn = -1;
            ++ptr[0];
        }
        while (Character.isDigit(data.charAt(ptr[0]))) {
            x = x * 10 + data.charAt(ptr[0]++) - '0';
        }
        return x * sgn;
    }
}
