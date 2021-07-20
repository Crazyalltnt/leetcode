/**
 * No.415 字符串相加
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/20 16:28
 */
public class L0415AddStrings {
    public static void main(String[] args) {

    }

    /**
     * 字符串相加
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 和
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum/ 10;
            ans.append(sum % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
