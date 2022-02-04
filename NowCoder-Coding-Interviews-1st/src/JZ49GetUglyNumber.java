/**
 * 剑指 Offer 49. 丑数
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/4 16:06
 */
public class JZ49GetUglyNumber {
    public static void main(String[] args) {

    }

    /**
     * 丑数
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param index 索引
     * @return 丑数
     */
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[index - 1];
    }
}
