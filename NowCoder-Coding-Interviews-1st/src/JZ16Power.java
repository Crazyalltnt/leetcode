/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/25 18:10
 */
public class JZ16Power {
    public static void main(String[] args) {

    }

    /**
     * 数值的整数次方 快速幂 递归
     * 时间复杂度 O(logN)
     * 空间复杂度 O(logN)
     *
     * @param base 基数
     * @param exponent 指数
     * @return 结果值
     */
    public double Power(double base, int exponent) {
        return (long)exponent >= 0 ? quickMul(base, exponent) : 1.0 / quickMul(base, -(long)exponent);
    }

    public double quickMul(double base, long exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        double res = quickMul(base, exponent / 2);
        return exponent % 2 == 0 ? res * res : res * res * base;
    }

    /**
     * 数值的整数次方 快速幂 迭代
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param base 基数
     * @param exponent 指数
     * @return 结果值
     */
    public double Power2(double base, int exponent) {
        long exp = exponent;
        double res = 1.0;
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res *= base;
            }
            base *= base;
            exp >>= 1;
        }
        return res;
    }

}
