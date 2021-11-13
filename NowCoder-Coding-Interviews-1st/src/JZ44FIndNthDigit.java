/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/13 19:12
 */
public class JZ44FIndNthDigit {
    public static void main(String[] args) {

    }

    /**
     * 数字序列中某一位的数字
     * 时间复杂度 O(logN)
     * 空间复杂度 O(logN)
     *
     * @param n 第n位
     * @return 指定位数字
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
