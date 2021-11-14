/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * @author Neil
 * @version v1.0
 * @date 2021/11/14 14:43
 */
public class JZ10Fib {
    public static void main(String[] args) {

    }

    /**
     * 斐波那契数列
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n 数
     * @return 值
     */
    public int Fibonacci(int n) {
        int p = 1, q = 1, r = 1;
        for (int i = 3; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }
}
