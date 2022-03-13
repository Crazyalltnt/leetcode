/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/10 21:58
 */
public class JZ17PrintNumbers {
    public static void main(String[] args) {

    }

    /**
     * 打印从1到最大的n位数
     *
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n 最大位数
     * @return 打印结果
     */
    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }

        int len = (int)Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 1; i < len; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
