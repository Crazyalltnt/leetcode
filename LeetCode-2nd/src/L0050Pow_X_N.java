/**
 * No.50 Pow(x, n)
 *
 * @author Neil
 * @version v1.0
 * @date 2021/10/6 14:30
 */
public class L0050Pow_X_N {
    public static void main(String[] args) {

    }

    /**
     * Pow(x, n) 快速幂 + 递归
     * 时间复杂度 O(logN)
     * 空间复杂度 O(logN)
     *
     * @param x 计算数
     * @param n 幂次
     * @return 结果
     */
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * Pow(x, n) 快速幂 + 迭代
     * 时间复杂度 O(logN)
     * 空间复杂度 O(logN)
     *
     * @param x 计算数
     * @param N 幂次
     * @return 结果
     */
    public double myPow2(double x, int n) {
        return (long)n >= 0 ? quickMul2(x, n) : 1.0 / quickMul2(x, -(long)n);
    }

    public double quickMul2(double x, long n) {
        double ans = 1.0;
        double xContribute = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= xContribute;
            }
            xContribute *= xContribute;
            n /= 2;
        }
        return ans;
    }
}
