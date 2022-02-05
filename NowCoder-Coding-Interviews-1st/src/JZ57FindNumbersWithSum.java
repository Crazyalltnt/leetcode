import java.util.ArrayList;

/**
 * 剑指 Offer 57. 和为s的两个数字
 *
 * @author Neil
 * @version v1.0
 * @date 2022/2/5 20:22
 */
public class JZ57FindNumbersWithSum {
    public static void main(String[] args) {

    }

    /**
     * 和为s的两个数字
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     * @param sum 和
     * @return 数字
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int i = 0, j = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < j) {
            int s = array[i] + array[j];
            if (s < sum) {
                i++;
            } else if (s > sum) {
                j--;
            } else {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }
        }
        return res;
    }
}
