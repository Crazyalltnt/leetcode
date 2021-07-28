
/**
 * No.69 x 的平方根
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/28 20:18
 */
public class L0069SqrtX {
    public static void main(String[] args) {

    }

    /**
     * x 的平方根 二分查找
     * 时间复杂度 O(logX)
     * 空间复杂度 O(1)
     *
     * @param x 非负整数
     * @return 平方根
     */
    public int mySqrt(int x) {
        long left = 0, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return (int)right;
    }

    /**
     * x 的平方根 二分查找2
     * 时间复杂度 O(logX)
     * 空间复杂度 O(1)
     *
     * @param x 非负整数
     * @return 平方根
     */
    public int mySqrt2(int x) {
        int left = 0, right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * x 的平方根 袖珍计算器
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     *
     * @param x 非负整数
     * @return 平方根
     */
    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
