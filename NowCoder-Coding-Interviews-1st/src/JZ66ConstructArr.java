/**
 * 剑指 Offer 66. 构建乘积数组
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/31 15:27
 */
public class JZ66ConstructArr {
    public static void main(String[] args) {

    }

    /**
     * 构建乘积数组 简化动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param A 数组
     * @return 数组B
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        if (len == 0) {
            return new int[0];
        }

        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * A[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    /**
     * 构建乘积数组 动态规划
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param A 数组
     * @return 数组B
     */
    public int[] multiply2(int[] A) {
        int len = A.length;
        if (len == 0) {
            return new int[0];
        }

        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * A[i- 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }

        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = left[i] * right[i];
        }
        return b;
    }
}
