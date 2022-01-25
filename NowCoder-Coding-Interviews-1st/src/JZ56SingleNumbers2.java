/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/25 22:09
 */
public class JZ56SingleNumbers2 {
    public static void main(String[] args) {

    }

    /**
     * 数组中数字出现的次数 II 有限状态机
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 数字
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    /**
     * 数组中数字出现的次数 II 遍历
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param nums 数组
     * @return 数字
     */
    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % 3;
        }
        return res;
    }

}
