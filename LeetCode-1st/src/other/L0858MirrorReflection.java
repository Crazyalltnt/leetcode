package other;

/**
 * No.858 镜面反射
 * https://leetcode-cn.com/problems/mirror-reflection
 *
 * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0，1，以及 2。
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 *
 * 示例：
 * 输入： p = 2, q = 1
 * 输出： 2
 * 解释： 这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 *
 * 提示：
 * 1 <= p <= 1000
 * 0 <= q <= p
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/29 10:03
 */
public class L0858MirrorReflection {
    public static void main(String[] args) {
        int p = 3;
        int q = 2;

        System.out.println(mirrorReflection(p, q));
    }

    static final double EPS = 1e-6;

    /**
     * 镜面反射 模拟
     * 时间复杂度 O(p)
     * 空间复杂度 O(1)
     *
     * @param p 边长
     * @param q 第一次落点
     * @return 接收器编号
     */
    public static  int mirrorReflection(int p, int q) {
        double x= 0, y = 0;
        double rx = p, ry = q;

        // 如果没有到达接收器，继续反射
        while (!( close(x, p) && (close(y, 0) || close(y, p)) || (close(x, 0) && close (y, p)))) {
            double t = 1e9;

            // x + rxt = 0, then t = -x/rx etc.
            if ((-x / rx) > EPS) {
                t = Math.min(t, -x / rx);
            }
            if ((-y / ry) > EPS) {
                t = Math.min(t, -y / ry);
            }
            if (((p - x) / rx) > EPS) {
                t = Math.min(t, (p - x) / rx);
            }
            if (((p - y) / ry) > EPS) {
                t = Math.min(t, (p - y) / ry);
            }

            x += rx * t;
            y += ry * t;

            if (close(x, p) || close(x, 0)) {
                rx = -rx;
            }
            if (close(y, p) || close(y, 0)) {
                ry = -ry;
            }
        }
        if (close(x, p) && close(y, p)) {
            return 1;
        }
        return close(x, p) ? 0 : 2;
    }

    /**
     * 判断是否在指定坐标位置
     *
     * @param x 当前坐标
     * @param y 指定坐标
     * @return 是否在指定坐标
     */
    public static boolean close(double x, double y) {
        return Math.abs(x - y) < EPS;
    }

    /**
     * 镜面反射 数学
     * 时间复杂度 O(logP)
     * 空间复杂度 O(1)
     *
     * @param p 边长
     * @param q 第一次落点
     * @return 接收器编号
     */
    public static  int mirrorReflection2(int p, int q) {
        // 最大公约数
        int g = gcd(p, q);

        // 最小公倍数 s=pq/gcd(p,q)
        // s=kq, s/q=k=p/g 为奇数到达东，偶数到达西
        p /= g;
        p %= 2;

        // s=kq, s/p=q/g 为奇数到达北，偶数到达南
        q /= g;
        q %= 2;

        if (p == 1 && q == 1) {
            return 1;
        }
        return p == 1 ? 0 : 2;
    }

    /**
     * 求最大公约数
     *
     * @param a 数1
     * @param b 数2
     * @return 最大公约数
     */
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
