/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/3 16:59
 */
public class JZ43NumberOf1Between1AndN {
    public static void main(String[] args) {

    }

    /**
     * 1～n 整数中 1 出现的次数
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n 最大值
     * @return 次数
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0, digit = 1;
        int cur = n % 10, low = 0, high = n / 10;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
