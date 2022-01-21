/**
 * 剑指 Offer 65. 不用加减乘除做加法
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/21 17:06
 */
public class JZ65Add {
    public static void main(String[] args) {

    }

    /**
     * 不用加减乘除做加法
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param a 数字1
     * @param b 数字2
     * @return 和
     */
    public int Add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
