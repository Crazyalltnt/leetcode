import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 37. 序列化二叉树
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/5 19:22
 */
public class JZ37Serialize {
    public static void main(String[] args) {

    }

    /**
     * 序列化二叉树 深度优先
     *
     * @author Neil
     * @date 2021/11/5 19:24
     * @version v1.0
     */
    // String Serialize(TreeNode root) {
    //     return rSerialize(root, "");
    // }
    //
    // TreeNode Deserialize(String str) {
    //     String[] dataArray = str.split(",");
    //     List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
    //     return rDeserialize(dataList);
    // }
    //
    // String rSerialize(TreeNode root, String str) {
    //     if (root == null) {
    //         str += "None";
    //     } else {
    //         str += String.valueOf(root.val) + ",";
    //         str = rSerialize(root.left, str);
    //         str = rSerialize(root.right, str);
    //     }
    //     return str;
    // }
    //
    // TreeNode rDeserialize(List<String> dataList) {
    //     if ("None".equals(dataList.get(0))) {
    //         dataList.remove(0);
    //         return null;
    //     }
    //
    //     TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
    //     dataList.remove(0);
    //     root.left = rDeserialize(dataList);
    //     root.right = rDeserialize(dataList);
    //     return root;
    // }

    /**
     * 序列化二叉树 深度优先 2
     *
     * @author Neil
     * @date 2021/11/5 19:59
     * @version v1.0
     */
    String Serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String left = "(" + Serialize(root.left) + ")";
        String right = "(" + Serialize(root.right) + ")";
        return left + root.val + right;
    }

    TreeNode Deserialize(String str) {
        int[] ptr = {0};
        return parse(str, ptr);
    }

    TreeNode parse(String data, int[] ptr) {
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

    TreeNode parseSubtree(String data, int[] ptr) {
        ++ptr[0];
        TreeNode subtree = parse(data, ptr);
        ++ptr[0];
        return subtree;
    }

    int parseInt(String data, int[] ptr) {
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
