/**
 * No.7 整数反转
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/23 10:35
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
     * @return 反转后的结果
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
