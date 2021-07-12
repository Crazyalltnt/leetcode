package binarysearch;

/**
 * No.50 Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/21 10:24
 */
public class L0050Pow {
    public static void main(String[] args) {

    }

    /**
     * 计算幂次 快速幂+递归
     * 时间复杂度 O(logN)
     * 空间复杂度 O(logN)
     *
     * @param x 原始数字
     * @param n 幂次
     * @return 结果
     */
    public static double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0  / quickMul(x, -n);
    }

    public static double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 计算幂次 快速幂+迭代
     * 时间复杂度 O(logN)
     * 空间复杂度 O(1)
     *
     * @param x 原始数字
     * @param n 幂次
     * @return 结果
     */
    public static double myPow2(double x, int n) {
        return n >= 0 ? quickMul2(x, n) : 1.0  / quickMul2(x, -n);
    }

    public static double quickMul2(double x, int n) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double xContribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= xContribute;
            }
            // 将贡献不断地平方
            xContribute *= xContribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return ans;
    }
}
