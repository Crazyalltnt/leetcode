package string;

/**
 * No.43 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字    0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/7 22:44
 */
public class L0043MultiplyStrings {
    public static void main(String[] args) {

    }

    /**
     * 字符串相乘 模拟
     * 时间复杂度 O(MN+N^2)
     * 空间复杂度 O(M+N)
     *
     * @param num1 字符串整数1
     * @param num2 字符串整数2
     * @return 乘积
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder cur = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                cur.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                cur.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                cur.append(add % 10);
            }
            ans = addStrings(ans, cur.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
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
        ans.reverse();
        return ans.toString();
    }

    /**
     * 字符串相乘 数组
     * 时间复杂度 O(MN)
     * 空间复杂度 O(M+N)
     *
     * @param num1 字符串整数1
     * @param num2 字符串整数2
     * @return 乘积
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] ansArray = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
           int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArray[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0 ; i--) {
            ansArray[i - 1] += ansArray[i] / 10;
            ansArray[i] %= 10;
        }
        int index = ansArray[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(ansArray[index]);
            index++;
        }
        return ans.toString();
    }
}
