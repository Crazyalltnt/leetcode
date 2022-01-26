/**
 * 剑指 Offer 64. 求1+2+…+n
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/26 15:19
 */
public class JZSumNums {
    public static void main(String[] args) {

    }

    /**
     * 求1+2+…+n 递归 使用了 if 不可取
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param n 数值
     * @return 和
     */
    public int Sum_Solution(int n) {
        if (n == 1) {
            return 1;
        }
        return n + Sum_Solution(n - 1);
    }

    /**
     * 求1+2+…+n 递归 位运算
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param n 数值
     * @return 和
     */
    public int Sum_Solution2(int n) {
        boolean x = (n > 1) && ((n += Sum_Solution2(n - 1)) > 0);
        return n;
    }
}
