package bitmanipulation;

/**
 * No.191 位1的个数
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/7 20:19
 */
public class L0191NumberOf1Bits {
    public static void main(String[] args) {

    }

    /**
     * 位1的个数 循环检查二进制位
     * 时间复杂度 O(32)
     * 空间复杂度 O(1)
     *
     * @param n W
     * @return 1的个数
     */
    public static int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                result++;
            }
            mask <<= 1;
        }
        return result;
    }

    /**
     * 位1的个数 位运算优化
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param n W
     * @return 1的个数
     */
    public static int hammingWeight2(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }
}
