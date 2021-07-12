package string;

/**
 * No.415 字符串相加
 * https://leetcode-cn.com/problems/add-strings
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 *
 * @author Neil
 * @version v1.0
 * @date 2021/6/12 23:07
 */
public class L0415AddStrings {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";

        System.out.println(addStrings(num1, num2));
    }

    /**
     * 字符串相加 模拟
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param num1 字符串非负整数1
     * @param num2 字符串非负整数2
     * @return 和
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
