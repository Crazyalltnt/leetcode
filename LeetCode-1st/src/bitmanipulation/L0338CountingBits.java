package bitmanipulation;

/**
 * No.338 比特位计数
 * https://leetcode-cn.com/problems/counting-bits
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的__builtin_popcount）来执行此操作。
 *
 * @author Neil
 * @version v1.0
 * @date 2021/5/10 16:25
 */
public class L0338CountingBits {
    public static void main(String[] args) {

    }

    /**
     * 比特位计数 循环计算
     * 时间复杂度 O(N * K)
     * 空间复杂度 O(1)
     *
     * @param num 非负整数
     * @return 1的数目
     */
    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int temp = i;
            while (temp > 0) {
                temp &= temp - 1;
                bits[i]++;
            }
        }
        return bits;
    }

    /**
     * 比特位计数 动态规划 最高有效位
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param num 非负整数
     * @return 1的数目
     */
    public static int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * 比特位计数 动态规划 最低有效位
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param num 非负整数
     * @return 1的数目
     */
    public static int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    /**
     * 比特位计数 动态规划 最低设置位
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param num 非负整数
     * @return 1的数目
     */
    public static int[] countBits4(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
