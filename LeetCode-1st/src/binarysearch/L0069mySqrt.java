package binarysearch;

/**
 * No.69 Sqrt(x)
 * https://leetcode-cn.com/problems/sqrtx
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 *
 * @author Neil
 * @version v1.0
 * @date 2021/4/24 16:15
 */
public class L0069mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }

    /**
     * x的平方根 袖珍计算器
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param x 非负整数
     * @return 平方根整数
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int res = (int)Math.exp(0.5 * Math.log(x));
        return (long)(res + 1) * (res + 1) <= x ? res + 1 : res;
    }

    /**
     * x的平方根 二分查找
     * 时间复杂度 O(logX)
     * 空间复杂度 O(1)
     *
     * @param x 非负整数
     * @return 平方根整数
     */
    public static int mySqrt2(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * x的平方根 牛顿法
     * 时间复杂度 O(logX)
     * 空间复杂度 O(1)
     *
     * @param x 非负整数
     * @return 平方根整数
     */
    public static int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
