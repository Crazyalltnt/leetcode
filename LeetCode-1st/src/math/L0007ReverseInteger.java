package math;

/**
 * No.7 整数反转
 * https://leetcode-cn.com/problems/reverse-integer
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -231 <= x <= 231 - 1
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/9 22:38
 */
public class L0007ReverseInteger {
    public static void main(String[] args) {

    }

    /**
     * 整数反转 字符串
     * 时间复杂度 O()
     * 空间复杂度 O()
     *
     * @param x 整数
     * @return 反转的整数
     */
    public int reverse(int x) {
        String num = String.valueOf(x);
        long reverseNum;
        if (Character.isDigit(num.charAt(0))) {
            reverseNum = Long.parseLong(new StringBuilder(num).reverse().toString());
        } else {
            reverseNum = Long.parseLong("-" + new StringBuilder(num.substring(1)).reverse().toString());

        }

        if (reverseNum < Integer.MIN_VALUE || reverseNum > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)reverseNum;
    }

    /**
     * 整数反转 数学
     * 时间复杂度 O(logX)
     * 空间复杂度 O(1)
     *
     * @param x 整数
     * @return 反转的整数
     */
    public int reverse2(int x) {
        int reverseNum = 0;
        while (x != 0) {
            if (reverseNum < Integer.MIN_VALUE / 10 || reverseNum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            reverseNum = reverseNum * 10 + digit;
        }
        return reverseNum;
    }
}
