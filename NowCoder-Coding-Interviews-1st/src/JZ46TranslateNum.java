/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/13 15:47
 */
public class JZ46TranslateNum {
    public static void main(String[] args) {

    }

    /**
     * 把数字翻译成字符串
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param nums 数字
     * @return 可能数
     */
    public int solve(String nums) {
        if ("".equals(nums) || "0".equals(nums)) {
            return 0;
        }
        int a = 1, b = 1;
        for (int i = 2; i <= nums.length(); i++) {
            String tmp = nums.substring(i - 2, i);
            if ("00".equals(tmp)) {
                return 0;
            }
            int c = tmp.compareTo("1") >= 0 && tmp.compareTo("26") <= 0 && !tmp.contains("0")? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
