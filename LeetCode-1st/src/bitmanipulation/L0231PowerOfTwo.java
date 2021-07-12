package bitmanipulation;

/**
 * No.231 2的幂
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/7 19:56
 */
public class L0231PowerOfTwo {
    public static void main(String[] args) {

    }

    /**
     * 2的幂 位运算：去除二进制中最右边的 1
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param n 整数
     * @return 是否2的幂次
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 2的幂 位运算：获取二进制中最右边的 1
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param n 整数
     * @return 是否2的幂次
     */
    public static boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        return ((long) n & (-(long) n)) == (long) n;
    }
}
