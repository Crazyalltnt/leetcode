/**
 * 剑指 Offer 15. 二进制中1的个数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/21 17:46
 */
public class JZ15NumberOf1 {
    public static void main(String[] args) {

    }

    /**
     * 二进制中1的个数
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param n 数字
     * @return 1的个数
     */
    public int NumberOf1(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    /**
     * 二进制中1的个数
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param n 数字
     * @return 1的个数
     */
    public int NumberOf12(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n&(n - 1);
        }
        return res;
    }
}
