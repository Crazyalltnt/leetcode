import java.util.ArrayList;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/5 17:27
 */
public class JZ74FindContinuousSequence {
    public static void main(String[] args) {

    }

    /**
     * 和为s的连续正数序列 数学
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param sum 和
     * @return 序列
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int i = 1;
        double j = 2.0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * sum + (long) i * i - i))) / 2;
            if (i < j &&  j == Math.ceil(j)) {
                ArrayList<Integer> ans = new ArrayList<>();
                for (int k = i; k <= (int)j; k++) {
                    ans.add(k);
                }
                res.add(ans);
            }
            i++;
        }
        return res;
    }

    /**
     * 和为s的连续正数序列 双指针 滑动窗口
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param sum 和
     * @return 序列
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        int i = 1, j = 2;
        int s = 3;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (i < j) {
            if (s == sum) {
                ArrayList<Integer> ans = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    ans.add(k);
                }
                res.add(ans);
            }
            if (s >= sum) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res;
    }
}
