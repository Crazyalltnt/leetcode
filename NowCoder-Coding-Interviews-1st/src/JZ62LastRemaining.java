import java.util.ArrayList;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 *
 * @author Neil
 * @version v1.0
 * @date 2022/1/26 20:35
 */
public class JZ62LastRemaining {
    public static void main(String[] args) {

    }

    /**
     * 圆圈中最后剩下的数字 链表 效率低
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(N)
     *
     * @param n 数
     * @param m 第m个
     * @return 最后剩下的数字
     */
    public int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * 圆圈中最后剩下的数字 数学
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param n 数
     * @param m 第m个
     * @return 最后剩下的数字
     */
    public int LastRemaining_Solution2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
